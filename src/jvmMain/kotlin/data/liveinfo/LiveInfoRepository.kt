package data.liveinfo

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class LiveInfoRepository(
    private val httpClient: HttpClient
) {

    private val totalCallsMutableStateFlow = MutableStateFlow(0)
    val totalCallsFlow: Flow<Int> = totalCallsMutableStateFlow

    private val totalFailsMutableStateFlow = MutableStateFlow(0)
    val totalFailsFlow: Flow<Int> = totalFailsMutableStateFlow

    suspend fun getLiveInfo(stationId: String, rule: String, date: Long?, preset: String) {
        try {
            httpClient.get("https://api.radiofrance.fr/livemeta/live/$stationId/$rule") {
                url {
                    parameters.append("preset", preset)
                    date?.let { parameters.append("date", date.toString()) }
                }
            }
        } catch (cancellationException: CancellationException) {
            throw cancellationException
        } catch (e: Exception) {
            totalFailsMutableStateFlow.update { it + 1 }
        } finally {
            totalCallsMutableStateFlow.update { it + 1 }
        }
    }
}
package data.liveinfo

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
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
        println("getLiveInfo() called with: stationId = $stationId, rule = $rule, date = $date, preset = $preset")

        val httpResponse = httpClient.get("https://api.radiofrance.fr/livemeta/live/$stationId/$rule") {
            headers {
                append(HttpHeaders.Accept, "application/json")
                append(HttpHeaders.UserAgent, "Spamminator - ${javaClass.`package`.implementationVersion}")
            }
            url {
                parameters.append("preset", preset)
                date?.let { parameters.append("date", date.toString()) }
            }
        }
        totalCallsMutableStateFlow.update { it + 1 }
        println("getLiveInfo() SUCCESS with: stationId = $stationId, rule = $rule, date = $date, preset = $preset")

        if (!httpResponse.status.isSuccess()) {
            totalFailsMutableStateFlow.update { it + 1 }
        }
    }
}
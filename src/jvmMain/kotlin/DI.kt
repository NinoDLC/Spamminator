import data.liveinfo.LiveInfoRepository
import data.preset.PresetRepository
import data.spam.SpamRepository
import data.station.StationRepository
import data.station.model.StationEntity
import domain.SpamLiveInfoUseCase
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.logging.*
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import ui.atoms.spam.SpamViewModel

@Suppress("MemberVisibilityCanBePrivate")
// TODO NINO Injection with Kodein ? https://voyager.adriel.cafe/screenmodel/kodein-integration
//  Koin doesn't work with Compose Desktop ATM
object DI {

    // Data
    val httpClient by lazy {
        HttpClient(OkHttp) {
            engine {
                config {
                    dispatcher(
                        Dispatcher().apply {
                            maxRequests = 500
                            maxRequestsPerHost = 500
                        }
                    )
                }
            }
            install(Logging) {
                level = LogLevel.INFO
            }
            install(UserAgent) {
                agent = "Spamminator - ${javaClass.`package`.implementationVersion}"
            }
        }
    }

    // Domain
    val ioDispatcher = Dispatchers.IO.limitedParallelism(500)
    val liveInfoRepository by lazy { LiveInfoRepository(httpClient) }
    val presetRepository by lazy { PresetRepository() }
    val stationRepository by lazy { StationRepository() }
    val spamRepository by lazy { SpamRepository() }

    val spamLiveInfoUseCase by lazy { SpamLiveInfoUseCase(spamRepository, liveInfoRepository, presetRepository) }

    // UI
    fun getSpamViewModel(stationEntity: StationEntity) = SpamViewModel(spamLiveInfoUseCase, stationEntity, spamRepository)
}
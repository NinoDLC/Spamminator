package domain

import data.liveinfo.LiveInfoRepository
import data.preset.PresetRepository
import data.spam.SpamRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger
import kotlin.time.Duration.Companion.seconds

class SpamLiveInfoUseCase(
    private val spamRepository: SpamRepository,
    private val liveInfoRepository: LiveInfoRepository,
    private val presetRepository: PresetRepository,
) {

    fun getSpamCountFlow(stationId: String): Flow<Int?> = channelFlow {
        spamRepository.stationSpammedMapStateFlow
            .map { stations -> stations.find { it.id == stationId } }
            .distinctUntilChanged()
            .collectLatest { stationEntity ->
                if (stationEntity != null) {
                    trySend(0)
                    val count = AtomicInteger(0)

                    while (true) {
                        presetRepository.presetsFlow.value.forEach {
                            launch {
                                liveInfoRepository.getLiveInfo(
                                    stationId = stationEntity.id,
                                    rule = stationEntity.liveRule,
                                    date = null,
                                    preset = it.value
                                )
                                trySend(count.incrementAndGet())
                            }
                        }

                        delay(10.seconds)
                    }
                } else {
                    trySend(null)
                }
            }
    }.conflate()
}
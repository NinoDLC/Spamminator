package domain

import data.liveinfo.LiveInfoRepository
import data.preset.PresetRepository
import data.station.model.StationEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger
import kotlin.time.Duration.Companion.seconds

class SpamLiveInfoUseCase(
    private val liveInfoRepository: LiveInfoRepository,
    private val presetRepository: PresetRepository,
) {

    fun getSpamCountFlow(stationEntity: StationEntity): Flow<Int> = channelFlow {
        trySend(0)
        val count = AtomicInteger(0)

        while (true) {
            launch {
                liveInfoRepository.getLiveInfo(
                    stationId = stationEntity.id,
                    rule = stationEntity.liveRule,
                    date = null,
                    preset = presetRepository.preset.value
                )

                trySend(count.incrementAndGet())
            }

            delay(1.seconds)
        }
    }.conflate()
}
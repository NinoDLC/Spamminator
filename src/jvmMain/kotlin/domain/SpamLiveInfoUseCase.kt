package domain

import data.liveinfo.LiveInfoRepository
import data.preset.PresetRepository
import data.spam.SpamRepository
import data.station.model.StationEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlin.time.Duration.Companion.seconds

class SpamLiveInfoUseCase(
    private val spamRepository: SpamRepository,
    private val liveInfoRepository: LiveInfoRepository,
    private val presetRepository: PresetRepository,
) {

    fun getSpamCountFlow(stationId: String): Flow<Int?> = spamRepository.stationSpammedMapStateFlow
        .map { stations -> stations.find { it.id == stationId } }
        .distinctUntilChanged()
        .flatMapLatest { stationEntity ->
            if (stationEntity != null) {
                getFlowsForPresets(stationEntity)
                    .merge()
                    .runningFold(0) { acc: Int, _: Unit -> acc + 1 }
            } else {
                flowOf(null)
            }
        }

    private fun getFlowsForPresets(stationEntity: StationEntity) = presetRepository.presetsFlow.value.map { preset ->
        flow {
            while (true) {
                liveInfoRepository.getLiveInfo(
                    stationId = stationEntity.id,
                    rule = stationEntity.liveRule,
                    date = null,
                    preset = preset.value
                )

                emit(Unit)

                delay(10.seconds)
            }
        }
    }
}
package ui.atoms.spam

import data.spam.SpamRepository
import data.station.model.StationEntity
import domain.SpamLiveInfoUseCase
import kotlinx.coroutines.flow.Flow

// TODO NINO Use Voyager for VM injection: https://github.com/Syer10/voyager
class SpamViewModel(
    spamLiveInfoUseCase: SpamLiveInfoUseCase,
    private val stationEntity: StationEntity,
    private val spamRepository: SpamRepository,
) {

    val spamCountFlow: Flow<Int?> = spamLiveInfoUseCase.getSpamCountFlow(stationEntity.id)

    fun onClick() {
        spamRepository.toggleSpam(stationEntity)
    }
}
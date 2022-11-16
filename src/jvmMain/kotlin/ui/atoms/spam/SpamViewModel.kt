package ui.atoms.spam

import data.station.model.StationEntity
import domain.SpamLiveInfoUseCase
import kotlinx.coroutines.flow.*

@Suppress("OPT_IN_USAGE")
// TODO NINO Use Voyager for VM injection: https://github.com/Syer10/voyager
class SpamViewModel(
    stationEntity: StationEntity,
    private val spamLiveInfoUseCase: SpamLiveInfoUseCase
) {

    private val isSpammingMutableStateFlow = MutableStateFlow(false)

    val spamCountFlow: Flow<Int?> = isSpammingMutableStateFlow.flatMapLatest { isSpamming ->
        if (isSpamming) {
            spamLiveInfoUseCase.getSpamCountFlow(stationEntity)
        } else {
            flowOf(null)
        }
    }

    fun onClick() {
        isSpammingMutableStateFlow.value = !isSpammingMutableStateFlow.value
    }
}
package data.spam

import data.station.model.StationEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SpamRepository {

    private val stationsSpammedMutableStateFlow = MutableStateFlow(emptyList<StationEntity>())
    val stationSpammedMapStateFlow = stationsSpammedMutableStateFlow.asStateFlow()

    fun toggleSpam(stationEntity: StationEntity) {
        stationsSpammedMutableStateFlow.update { stations ->
            if (stations.contains(stationEntity)) {
                stations - stationEntity
            } else {
                stations + stationEntity
            }
        }
    }
}
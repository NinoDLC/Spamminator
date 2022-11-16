package data.station.model

data class StationEntity(
    val id: String,
    val name: String,
    val icon: String,
    val color: Long,
    val liveRule: String,
)
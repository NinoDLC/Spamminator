package data.liveinfo.model

import java.time.Instant

data class LiveInfoItemEntity(
    val firstLine: String,
    val secondLine: String?,
    val coverUrl: String?,
    val conceptId: String?,
    val expressionId: String?,
    val trackId: String?,
    val favouriteType: FavouriteType?,
    val startTime: Instant?,
    val endTime: Instant?,
) {
    sealed class FavouriteType {
        data class Concept(val conceptId: String) : FavouriteType()
        data class Expression(val expressionId: String) : FavouriteType()
        data class Track(val trackId: String) : FavouriteType()
    }
}

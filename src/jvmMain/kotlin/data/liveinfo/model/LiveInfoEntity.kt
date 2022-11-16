package data.liveinfo.model

import kotlin.time.Duration

data class LiveInfoEntity(
    val previous: List<LiveInfoItemEntity>,
    val now: LiveInfoItemEntity,
    val next: List<LiveInfoItemEntity>,
    val delayToRefresh: Duration
)

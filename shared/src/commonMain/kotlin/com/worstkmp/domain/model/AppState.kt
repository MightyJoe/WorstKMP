package com.worstkmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AppState(
    val lastScreen: String = "HOME",
    val lastScreenJSON: String? = "", // JSON DATA
    val backStackJSON: String? = "",
    val lastUpdated: Long = 0L
) {
    override fun toString(): String {
        return "AppState(lastScreen='$lastScreen', lastScreenJSON='$lastScreenJSON', backStackJSON='$backStackJSON', lastUpdated=$lastUpdated)"
    }

}
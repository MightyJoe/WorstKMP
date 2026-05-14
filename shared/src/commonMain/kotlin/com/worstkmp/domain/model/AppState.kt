package com.worstkmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AppState(
    val lastScreen: String = "HOME",
    val lastScreenJSON: String? = null,
    val backStackJSON: String? = null,
    val lastUpdated: Long = 0L
)
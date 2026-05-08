package com.worstkmp

// This is shared across all platforms
interface Platform {
    val name: String
}

// Every platform (Android, Desktop, iOS) must provide its own implementation
expect fun getPlatform(): Platform


package com.worstkmp.data.local

import app.cash.sqldelight.db.SqlDriver

// Context is optional for desktop/iOS — Koin supplies it on Android only
expect class DatabaseDriverFactory(context: Any? = null) {
    fun createDriver(): SqlDriver
}
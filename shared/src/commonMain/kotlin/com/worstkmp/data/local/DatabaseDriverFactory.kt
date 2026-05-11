package com.worstkmp.data.local

import app.cash.sqldelight.db.SqlDriver

// Context is optional so desktop/iOS don't break
expect class DatabaseDriverFactory(context: Any? = null) {
    fun createDriver(): SqlDriver
}
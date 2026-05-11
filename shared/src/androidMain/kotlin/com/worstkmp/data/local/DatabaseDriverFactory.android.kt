package com.worstkmp.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.worstkmp.WorstDatabase

actual class DatabaseDriverFactory actual constructor(
    private val context: Any?   // ← NO "= null" here
) {
    actual fun createDriver(): SqlDriver {
        val androidContext = context as? Context
            ?: throw IllegalStateException("Context is required on Android")

        return AndroidSqliteDriver(
            schema = WorstDatabase.Schema,
            context = androidContext,
            name = "worstkmp.db"
        )
    }
}
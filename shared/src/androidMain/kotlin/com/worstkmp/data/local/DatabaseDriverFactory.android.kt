package com.worstkmp.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.worstkmp.WorstDatabase

actual class DatabaseDriverFactory actual constructor(
    private val context: Any?   // Koin will inject this on Android
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = WorstDatabase.Schema,
            context = context as Context,  // safe because Koin provides Context on Android
            name = "worstkmp.db"
        )
    }
}
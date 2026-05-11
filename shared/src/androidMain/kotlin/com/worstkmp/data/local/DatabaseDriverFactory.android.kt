package com.worstkmp.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.worstkmp.WorstDatabase

actual class DatabaseDriverFactory actual constructor(
    private val context: Context?   // Koin gives us the real Context here
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = WorstDatabase.Schema,
            context = context!!,           // safe because Koin only runs this on Android
            name = "worstkmp.db"
        )
    }
}
package com.worstkmp.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.worstkmp.WorstDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = WorstDatabase.Schema,      // tells it which tables to create
            context = context,
            name = "worstkmp.db"                // filename of the database
        )
    }
}
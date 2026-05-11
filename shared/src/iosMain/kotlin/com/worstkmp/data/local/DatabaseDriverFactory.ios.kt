package com.worstkmp.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.worstkmp.WorstDatabase

actual class DatabaseDriverFactory actual constructor(context: Any?) {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(WorstDatabase.Schema, "worstkmp.db")
    }
}
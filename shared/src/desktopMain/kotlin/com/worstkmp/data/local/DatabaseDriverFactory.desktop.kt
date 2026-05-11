package com.worstkmp.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.worstkmp.WorstDatabase
import java.io.File

actual class DatabaseDriverFactory actual constructor(context: Any?) {
    actual fun createDriver(): SqlDriver {
        val dbFile = File("worstkmp.db")
        return JdbcSqliteDriver(
            schema = WorstDatabase.Schema,
            url = "jdbc:sqlite:${dbFile.absolutePath}"
        )
    }
}
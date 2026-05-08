package com.worstkmp.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.worstkmp.WorstDatabase   // generated from your .sq file
import java.io.File

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        // Desktop stores the DB file right next to the app executable
        // → this is what gives us real persistence across app kills/re-opens
        val dbFile = File("worstkmp.db")

        return JdbcSqliteDriver(
            schema = WorstDatabase.Schema,                    // tells SQLDelight how to create tables
            url = "jdbc:sqlite:${dbFile.absolutePath}"        // real file on disk
        )
    }
}
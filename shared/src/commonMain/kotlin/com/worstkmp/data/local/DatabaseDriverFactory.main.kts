package com.worstkmp.data.local

import com.worstkmp.WorstDatabase
import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DatabaseDriverFactory): WorstDatabase {
    return WorstDatabase(driverFactory.createDriver())
}
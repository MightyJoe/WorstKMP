package com.worstkmp.data.local

import app.cash.sqldelight.db.SqlDriver
import com.worstkmp.WorstDatabase

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

fun createWorstDatabase(driverFactory: DatabaseDriverFactory): WorstDatabase {
    val driver = driverFactory.createDriver()
    val database = WorstDatabase(driver)

    // Optional: Create tables on first run
    WorstDatabase.Schema.create(driver)

    return database
}
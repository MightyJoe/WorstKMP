package com.worstkmp.di

import com.worstkmp.WorstDatabase
import com.worstkmp.data.local.DatabaseDriverFactory
import com.worstkmp.data.local.SqlDelightCalibrationRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    // Koin will inject Context on Android, null on desktop/iOS
    single { DatabaseDriverFactory(getOrNull()) }

    single {
        val driverFactory = get<DatabaseDriverFactory>()
        val driver = driverFactory.createDriver()
        WorstDatabase(driver)
    }

    singleOf(::SqlDelightCalibrationRepository)

}
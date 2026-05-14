package com.worstkmp.di

import android.content.Context
import com.worstkmp.data.local.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidAppModule = module {
    // This one actually receives the real Context from androidContext(...)
    single { DatabaseDriverFactory(androidContext()) }
}


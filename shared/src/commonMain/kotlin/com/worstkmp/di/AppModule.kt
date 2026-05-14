package com.worstkmp.di

import com.worstkmp.WorstDatabase
import com.worstkmp.data.local.AppStateRepository
import com.worstkmp.data.local.CalibrationRepository
import com.worstkmp.data.local.DatabaseDriverFactory
import com.worstkmp.data.local.SqlDelightAppStateRepository
import com.worstkmp.data.local.SqlDelightCalibrationRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * Koin module for the app.
 * This is the central place for DI (Dependency Injection) rules/configuration.
 * 
 * # Koin DSL Functions Explained:
 * 
 * ## `single { }` - Singleton Definition
 * Creates a singleton instance (only one instance exists for the entire app lifetime).
 * The lambda is executed only once when first requested.
 * Example: `single { DatabaseDriverFactory(getOrNull()) }`
 * 
 * ## `singleOf(::Constructor)` - Concise Singleton Definition
 * Shorthand for `single { Constructor(get(), get(), ...) }`.
 * Koin automatically resolves and injects all constructor parameters.
 * Example: `singleOf(::SqlDelightCalibrationRepository)` is equivalent to 
 * `single { SqlDelightCalibrationRepository(get()) }`
 * 
 * ## `bind Interface::class` - Type Binding
 * Tells Koin "when someone requests Interface, provide this implementation".
 * Allows dependency injection via interface instead of concrete class.
 * Example: `singleOf(::SqlDelightCalibrationRepository) bind CalibrationRepository::class`
 * means injecting `CalibrationRepository` will provide `SqlDelightCalibrationRepository`.
 * 
 * ## `get<Type>()` - Dependency Resolution
 * Retrieves a dependency from Koin's container within a definition.
 * Koin resolves the requested type based on previous definitions.
 * Example: `get<DatabaseDriverFactory>()` retrieves the DatabaseDriverFactory singleton.
 * 
 * ## `getOrNull<Type>()` - Optional Dependency Resolution
 * Like `get()` but returns null if dependency doesn't exist (platform-specific).
 * Example: `getOrNull<Context>()` returns Android Context on Android, null on iOS/Desktop.
 * 
 * ## `inject()` - Lazy Injection (in components)
 * Used in classes implementing `KoinComponent` to lazily inject dependencies.
 * Example: `private val service: GreetingService by inject()`
 * The dependency is resolved when first accessed, not at object creation.
 * 
 * ## Other Scopes:
 * - `factory { }` - Creates a NEW instance every time it's requested (not singleton)
 * - `scoped { }` - Creates one instance per scope (useful for ViewModels per screen)
 */
val appModule = module {

//    // Step 1: Create the DatabaseDriverFactory as a singleton
//    // This factory is responsible for creating the database driver (the low-level database connection)
//    // getOrNull() tries to inject an Android Context on Android, or returns null on desktop/iOS
//    // Koin automatically provides the right value based on the platform
//    single { DatabaseDriverFactory(getOrNull()) }

    // Step 2: Create the WorstDatabase instance as a singleton
    // This is your main database object that you'll use throughout the app
    single {
        // get<DatabaseDriverFactory>() asks Koin to give us the DatabaseDriverFactory we created above
        val driverFactory = get<DatabaseDriverFactory>()
        // Use the factory to create the actual database driver (SQLite connection)
        val driver = driverFactory.createDriver()
        // Pass the driver to WorstDatabase to create our database instance
        WorstDatabase(driver)
    }

    // Step 3: Create the CalibrationRepository implementation as a singleton
    // singleOf(::SqlDelightCalibrationRepository) is Koin's shorthand for creating a singleton
    // The ::SqlDelightCalibrationRepository syntax passes the constructor reference
    // Koin automatically injects WorstDatabase into SqlDelightCalibrationRepository's constructor
    // bind CalibrationRepository::class tells Koin "when someone asks for CalibrationRepository, give them this"
    singleOf(::SqlDelightCalibrationRepository) bind CalibrationRepository::class

    //SETP 4: Create the AppStateRepository implementation as a singleton
    singleOf(::SqlDelightAppStateRepository) bind AppStateRepository::class

    // Step 5: Create the GreetingService as a singleton
    // single<GreetingService> declares we're creating a GreetingService implementation
    // { GreetingServiceImpl() } creates a new instance of GreetingServiceImpl
    // When code asks for GreetingService, Koin will provide this GreetingServiceImpl instance
    single<GreetingService> { GreetingServiceImpl() }
}
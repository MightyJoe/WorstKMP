plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqlDelight)
}

kotlin {
    androidTarget()
    jvm("desktop")
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        // commonMain = code that runs on ALL platforms (Android + Desktop + iOS)
        // This is where most of your business logic, models, ViewModels, and SQLDelight queries live.
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)   // For StateFlow, viewModelScope, etc.
            implementation(libs.sqlDelight.runtime)        // Core SQLDelight engine (tables, queries)
            implementation(libs.coroutines.extensions)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.screenmodel)
        }

        // androidMain = code that ONLY runs on Android
        // The Android-specific SQLite driver.
        androidMain.dependencies {
            implementation(libs.sqlDelight.android.driver)   // AndroidSqliteDriver + Android SQLite bindings
        }

        // desktopMain = code that ONLY runs on Desktop (JVM)
        // Uses JDBC (regular Java SQLite driver).
        jvmMain.dependencies {
            implementation(libs.sqlDelight.jdbc.driver)      // JdbcSqliteDriver for desktop
        }

        // === iOS Setup ===

        // iosMain = a virtual source set that both iOS targets share
        // Created so we don't have to duplicate iOS code twice. Once for the real device, and once for the simulator.
        // iOS doesn't share both like android does.
        iosMain.dependencies {
            implementation(libs.sqlDelight.native.driver)   // NativeSqliteDriver for iOS
        }
    }
}

sqldelight {
    databases {
        create("WorstDatabase") {
            packageName.set("com.worstkmp")
            srcDirs.setFrom("src/commonMain/sqldelight")
        }
    }
}

// Android configuration
android {
    namespace = "com.worstkmp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
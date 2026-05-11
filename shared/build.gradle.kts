import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

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
        // This is where most of the business logic, models, ViewModels, and SQLDelight queries live.
        val commonMain: KotlinSourceSet by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)   // For StateFlow, viewModelScope, etc.
                implementation(libs.sqlDelight.runtime)        // Core SQLDelight engine (tables, queries)
                implementation(libs.coroutines.extensions)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.voyager.navigator)
                implementation(libs.voyager.screenmodel)
                implementation(libs.koin.core)
                implementation(libs.koin.compose)
                implementation(libs.koin.compose.viewmodel)
            }
        }

        // androidMain = code that ONLY runs on Android
        // The Android-specific SQLite driver.
        val androidMain: KotlinSourceSet by getting {
            dependencies {
                implementation(libs.sqlDelight.android.driver)   // AndroidSqliteDriver + Android SQLite bindings
                implementation(libs.koin.android)
            }
        }

        // desktopMain = code that ONLY runs on Desktop (JVM)
        // Uses JDBC (regular Java SQLite driver).
        val desktopMain: KotlinSourceSet by getting {
            dependencies {
                implementation(libs.sqlDelight.jdbc.driver)      // JdbcSqliteDriver for desktop
            }
        }

        // === iOS Setup ===

        // iosMain = a virtual source set that both iOS targets share
        // Created so we don't have to duplicate iOS code twice.
        val iosMain: KotlinSourceSet by creating {
            dependsOn(commonMain)
        }
        val iosArm64Main: KotlinSourceSet by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Main: KotlinSourceSet by getting {
            dependsOn(iosMain)
        }

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
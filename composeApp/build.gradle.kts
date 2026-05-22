import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
}

kotlin {
    androidTarget()
    jvm("desktop")

    // === Declare iOS targets ONCE (critical for linkerOpts) ===
    val iosArm64 = iosArm64()
    val iosSimulatorArm64 = iosSimulatorArm64()

    // === SQLDelight iOS Linker Fix (must be here + in composeApp) ===
    listOf(iosArm64, iosSimulatorArm64).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            linkerOpts("-lsqlite3")   // This tells iOS to include the system SQLite library
        }
    }

    sourceSets {
        // commonMain = code that runs on ALL platforms (Android + Desktop + iOS)
        // This is where most of the business logic, models, ViewModels, and SQLDelight queries live.
        val commonMain: KotlinSourceSet by getting {
            dependencies {
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.ui)
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

android {
    namespace = "com.worstkmp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.worstkmp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(libs.compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "com.worstkmp.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.worstkmp"
            packageVersion = "1.0.0"
        }
    }
}

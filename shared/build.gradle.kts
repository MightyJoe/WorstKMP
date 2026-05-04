plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.sqlDelight)   // we'll add the version in libs.versions.toml next
}

kotlin {
    androidTarget()
    jvm("desktop")
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.sqlDelight.runtime)
            // Kable for Bluetooth later
            // implementation("com.juul.kable:core:0.20.0")
        }
    }
}

sqldelight {
    databases {
        create("WorstDatabase") {
            packageName = "com.worstkmp"
            sourceFolders = ["sqldelight"]
        }
    }
}
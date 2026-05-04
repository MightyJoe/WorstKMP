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
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.sqlDelight.runtime)
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
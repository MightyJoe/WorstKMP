import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.sqlDelight)
}

kotlin {
    android {
        namespace = "com.worstkmp.shared"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
    jvm("desktop")

    val iosArm64 = iosArm64()
    val iosSimulatorArm64 = iosSimulatorArm64()

    // === SQLDelight iOS Linker Fix (must be in BOTH projects) ===
    listOf(iosArm64, iosSimulatorArm64).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            linkerOpts("-lsqlite3")
        }
    }

    sourceSets {
        val commonMain: KotlinSourceSet by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.sqlDelight.runtime)
                implementation(libs.coroutines.extensions)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.voyager.navigator)
                implementation(libs.voyager.screenmodel)
                implementation(libs.koin.core)
                implementation(libs.koin.compose)
                implementation(libs.koin.compose.viewmodel)
            }
        }

        val androidMain: KotlinSourceSet by getting {
            dependencies {
                implementation(libs.sqlDelight.android.driver)
                implementation(libs.koin.android)
            }
        }

        val desktopMain: KotlinSourceSet by getting {
            dependencies {
                implementation(libs.sqlDelight.jdbc.driver)
            }
        }

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
            implementation(libs.sqlDelight.native.driver)
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

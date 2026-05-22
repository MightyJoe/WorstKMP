import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
}

kotlin {
    android {
        namespace = "com.worstkmp.app"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()
        androidResources { enable = true }
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    jvm("desktop")

    val iosArm64 = iosArm64()
    val iosSimulatorArm64 = iosSimulatorArm64()

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
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.ui)
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
                implementation(compose.desktop.currentOs)
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

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.library")
    kotlin("android")
    alias(libs.plugins.arrow.analysis.group)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
    }

    buildFeatures {
        compose = false
    }
}

dependencies {
    api(libs.klock)

    implementation(libs.bundles.logging)

    testImplementation(libs.kotlin.reflect)

    testImplementation(libs.bundles.kotest)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

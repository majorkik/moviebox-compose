plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        buildToolsVersion = AndroidConfig.buildTools
    }

    buildFeatures {
        buildConfig = false // Disable generation of BuildConfig files in modules where they are not needed

        aidl = false
        prefab = false
        shaders = false

        compose = false

        dataBinding = false
        viewBinding = false
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    api(Libs.Kotlin.stdlib)

    api(Libs.Koin.core)

    api(Libs.Loggers.timber)
    api(Libs.Loggers.prettyLogger)
}

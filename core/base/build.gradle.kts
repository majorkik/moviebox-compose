plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
}

android {
    buildFeatures {
        buildConfig = false // Disable generation of BuildConfig files in modules where they are not needed

        aidl = false
        prefab = false
        shaders = false

        compose = false

        dataBinding = false
        viewBinding = false
    }
}

dependencies {
    api(Libs.Kotlin.stdlib)

    api(Libs.Koin.core)

    api(Libs.Loggers.timber)
    api(Libs.Loggers.prettyLogger)
}

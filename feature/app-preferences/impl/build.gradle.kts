plugins {
    id(Plugin.androidLibrary)
    kotlin(Plugin.android)
    id(Plugin.Arrow.group)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
    }

    buildFeatures {
        aidl = false
        shaders = false
        resValues = false
        renderScript = false
    }
}

dependencies {
    implementation(project(ModuleDependency.Feature.AppPreferences.api))

    implementation(Dependency.Koin.android)

    implementation(Dependency.AndroidX.DataStore.preferences)

    implementation(Dependency.Loggers.prettyLogger)
}

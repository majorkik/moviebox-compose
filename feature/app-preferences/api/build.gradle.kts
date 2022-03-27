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
}

dependencies {
    implementation(Dependency.AndroidX.DataStore.preferences)

    implementation(Dependency.Coroutines.core)

    implementation(Dependency.Loggers.prettyLogger)
}

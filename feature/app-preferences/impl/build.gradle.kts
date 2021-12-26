plugins {
    id(Plugin.androidLibrary)
    kotlin(Plugin.android)
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(project(ModuleDependency.Feature.Tmdb.api))

    implementation(Dependency.Koin.core)

    implementation(Dependency.AndroidX.DataStore.preferences)

    implementation(Dependency.Loggers.prettyLogger)
}

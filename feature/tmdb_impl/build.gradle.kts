plugins {
    id(Plugin.androidLibrary)
    kotlin(Plugin.android)
    kotlin(Plugin.kotlinSerialization)
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
    implementation(project(ModuleDependency.Feature.tmdbApi))

    implementation(Dependency.Kotlin.serialization)
    implementation(Dependency.Koin.core)

    // Network
    implementation(platform(Dependency.Network.OkHTTP.bom))

    implementation(Dependency.Network.OkHTTP.core)
    implementation(Dependency.Network.OkHTTP.loggingInterceptor)

    implementation(Dependency.Network.serializationConverter)
}

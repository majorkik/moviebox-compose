import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(Plugin.androidLibrary)
    kotlin(Plugin.android)
    kotlin(Plugin.kotlinSerialization)
}

android {
    val key: String = gradleLocalProperties(rootDir).getProperty("tmdb_key")

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

    buildTypes {
        debug {
            buildConfigField("String", "TMDB_API_KEY", key)
        }

        release {
            buildConfigField("String", "TMDB_API_KEY", key)
        }
    }
}

dependencies {
    implementation(project(ModuleDependency.Feature.Tmdb.api))

    implementation(Dependency.Kotlin.serialization)
    implementation(Dependency.Coroutines.core)

    implementation(Dependency.Koin.core)

    implementation(Dependency.Loggers.prettyLogger)

    // Network
    implementation(platform(Dependency.Network.OkHTTP.bom))

    implementation(Dependency.Network.OkHTTP.core)
    implementation(Dependency.Network.OkHTTP.loggingInterceptor)

    implementation(Dependency.Network.serializationConverter)

    implementation(Dependency.Other.sandwich)
    implementation(Dependency.Other.klock)
}

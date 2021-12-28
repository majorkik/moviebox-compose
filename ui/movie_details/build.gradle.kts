import Version.composeCompiler

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
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeCompiler
    }
}

dependencies {
    implementation(project(ModuleDependency.Core.ui))
    implementation(project(ModuleDependency.Feature.Tmdb.api))

    implementation(Dependency.Koin.compose)
    implementation(Dependency.Other.mviOrbit)

    implementation(Dependency.Other.coil)

    implementation(Dependency.Accompanist.pager)
    implementation(Dependency.Accompanist.pager_indicators)

    implementation(Dependency.Loggers.prettyLogger)

    implementation(Dependency.Other.klock)
}

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
        compose = false
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
    api(Dependency.Other.klock)

    implementation(Dependency.Loggers.prettyLogger)

    testImplementation(Dependency.Kotlin.reflect)

    testImplementation(Dependency.Tests.Kotest.assertions)
    testImplementation(Dependency.Tests.Kotest.junitRunner)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

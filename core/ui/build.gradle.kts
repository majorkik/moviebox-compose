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

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }
}

dependencies {
    api(Dependency.AndroidX.appcompat)
    api(Dependency.AndroidX.Compose.ui)
    api(Dependency.AndroidX.Compose.tooling)
    api(Dependency.AndroidX.Compose.toolingPreview)
    api(Dependency.AndroidX.Compose.runtime)
    api(Dependency.AndroidX.Compose.foundation)
    api(Dependency.AndroidX.Compose.material)
}

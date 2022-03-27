import Version.composeCompiler

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
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeCompiler
    }
}

dependencies {
    api(Dependency.AndroidX.appcompat)

    api(Dependency.AndroidX.Compose.compiler)
    api(Dependency.AndroidX.Compose.ui)
    api(Dependency.AndroidX.Compose.tooling)
    api(Dependency.AndroidX.Compose.toolingPreview)
    api(Dependency.AndroidX.Compose.runtime)
    api(Dependency.AndroidX.Compose.foundation)
    api(Dependency.AndroidX.Compose.material)

    api(Dependency.Accompanist.insets)
}

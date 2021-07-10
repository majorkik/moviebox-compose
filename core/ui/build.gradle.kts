plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
}

android {
    buildFeatures {
        buildConfig = false // Disable generation of BuildConfig files in modules where they are not needed

        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
    }
}

dependencies {
    api(Libs.Koin.android)
    api(Libs.Koin.compose)

    api(Libs.AndroidX.annotation)

    api(Libs.AndroidX.Compose.layout)
    api(Libs.AndroidX.Compose.material)
    api(Libs.AndroidX.Compose.tooling)
    api(Libs.AndroidX.Compose.uiUtil)
    api(Libs.AndroidX.Compose.runtime)
    api(Libs.AndroidX.Compose.runtimeLivedata)
    api(Libs.AndroidX.Compose.viewBinding)
}

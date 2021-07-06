plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
}

android {
    buildFeatures {
        buildConfig = false // Disable generation of BuildConfig files in modules where they are not needed

        compose = true
    }
}

dependencies {
    api(Libs.AndroidX.coreKtx)
    api(Libs.AndroidX.material)
    api(Libs.AndroidX.multidex)
    api(Libs.AndroidX.navigationCompose)

    api(Libs.Koin.android)
    api(Libs.Koin.compose)

    api(Libs.AndroidX.annotation)
    api(Libs.AndroidX.Activity.activityCompose)
    api(Libs.AndroidX.vectorDrawable)

    api(Libs.AndroidX.Lifecycle.livedata)
    api(Libs.AndroidX.Lifecycle.viewModelCompose)

    api(Libs.AndroidX.Compose.layout)
    api(Libs.AndroidX.Compose.material)
    // api(Libs.AndroidX.Compose.materialIconsExtended)
    api(Libs.AndroidX.Compose.tooling)
    api(Libs.AndroidX.Compose.uiUtil)
    api(Libs.AndroidX.Compose.runtime)
    api(Libs.AndroidX.Compose.runtimeLivedata)
    api(Libs.AndroidX.Compose.viewBinding)

    api(Libs.Accompanist.coil)
    api(Libs.Accompanist.insets)

    api(Libs.Others.stfalconImageViewer)
}

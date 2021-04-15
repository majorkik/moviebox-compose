plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
}

android {
    compileSdkVersion(AndroidConfig.compileSdk)

    defaultConfig {
        minSdkVersion(AndroidConfig.minSdk)
        targetSdkVersion(AndroidConfig.targetSdk)
        buildToolsVersion(AndroidConfig.buildTools)

        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
    }

    buildFeatures {
        buildConfig = false // Disable generation of BuildConfig files in modules where they are not needed
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isDebuggable = BuildTypeRelease.isDebuggable
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isDebuggable = BuildTypeDebug.isDebuggable
        }
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    api(Libs.AndroidX.coreKtx)
    api(Libs.AndroidX.material)
    api(Libs.AndroidX.multidex)

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

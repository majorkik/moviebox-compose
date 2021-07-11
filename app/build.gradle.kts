plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.android)
    id(Plugins.kapt)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.applicationId

        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isDebuggable = BuildTypeRelease.isDebuggable
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isDebuggable = BuildTypeDebug.isMinifyEnabled
        }
    }

    buildFeatures {
        compose = false
        viewBinding = false
        dataBinding = false

        // Disable unused AGP features
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
    }
}

dependencies {
    implementation(project(ModuleDependency.Core.ui))

    implementation(project(ModuleDependency.UI.main))
    implementation(project(ModuleDependency.UI.home))

    implementation(Libs.AndroidX.compat)

    implementation(Libs.Koin.android)

    implementation(Libs.Loggers.timber)
    implementation(Libs.Loggers.prettyLogger)
}

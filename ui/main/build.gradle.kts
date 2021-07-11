plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
}

android {
    buildFeatures {
        buildConfig = false // Disable generation of BuildConfig files in modules where they are not needed

        aidl = false
        prefab = false
        shaders = false

        compose = true

        dataBinding = false
        viewBinding = false
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
    }
}

dependencies {
    implementation(project(ModuleDependency.Core.ui))

    implementation(Libs.AndroidX.Activity.activityCompose)
    implementation(Libs.AndroidX.compat)

    implementation(Libs.Koin.android)
}

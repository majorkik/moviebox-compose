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
}

dependencies {
    implementation(project(ModuleDependency.Core.common))
    implementation(Dependency.Loggers.prettyLogger)
    implementation(Dependency.Other.klock)
}

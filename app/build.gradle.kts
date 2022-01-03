import Version.composeCompiler

plugins {
    id(Plugin.androidApplication)
    kotlin(Plugin.android)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        vectorDrawables {
            useSupportLibrary = AndroidConfig.useSupportLibrary
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeCompiler
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Modules
    implementation(project(ModuleDependency.Core.ui))

    implementation(project(ModuleDependency.navigation))

    implementation(project(ModuleDependency.UI.movieDetails))

    implementation(project(ModuleDependency.UI.navHome))
    implementation(project(ModuleDependency.UI.navSearch))
    implementation(project(ModuleDependency.UI.navProfile))

    implementation(project(ModuleDependency.Feature.Tmdb.impl))
    implementation(project(ModuleDependency.Feature.AppPreferences.api))
    implementation(project(ModuleDependency.Feature.AppPreferences.impl))

    // Libraries
    implementation(Dependency.AndroidX.core)
    implementation(Dependency.AndroidX.appcompat)
    implementation(Dependency.AndroidX.material)
    implementation(Dependency.AndroidX.activityCompose)

    implementation(Dependency.AndroidX.Compose.compiler)
    implementation(Dependency.AndroidX.Compose.ui)
    implementation(Dependency.AndroidX.Compose.tooling)
    implementation(Dependency.AndroidX.Compose.toolingPreview)
    implementation(Dependency.AndroidX.Compose.runtime)
    implementation(Dependency.AndroidX.Compose.foundation)
    implementation(Dependency.AndroidX.Compose.material)

    implementation(Dependency.Koin.android)
    implementation(Dependency.Koin.compose)

    implementation(Dependency.Loggers.prettyLogger)
    implementation(Dependency.Loggers.timber)

    implementation(Dependency.AndroidX.navigationCompose)

    implementation(Dependency.Accompanist.navigationMaterial)
    implementation(Dependency.Accompanist.navigationAnimation)
    implementation(Dependency.Accompanist.insets)
    implementation(Dependency.Accompanist.systemUIController)

    testImplementation(Dependency.Koin.tests)
}

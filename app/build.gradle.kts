@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.application")
    kotlin("android")
    alias(libs.plugins.arrow.analysis.group)
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.navigation)
    implementation(projects.ui.movieDetails)
    implementation(projects.ui.navHome)
    implementation(projects.ui.navProfile)
    implementation(projects.ui.navSearch)
    implementation(projects.feature.tmdb.impl)
    implementation(projects.feature.appPreferences.api)
    implementation(projects.feature.appPreferences.impl)

    implementation(libs.bundles.androidx.ui)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.loggers)

    implementation(libs.koin.android)
    implementation(libs.koin.compose)

//    implementation(libs.androidx.)

    implementation(libs.accompanist.navigation.animation)
    implementation(libs.accompanist.navigation.material)
    implementation(libs.accompanist.insets)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.ui.controller)

    testImplementation(libs.koin.test)
}

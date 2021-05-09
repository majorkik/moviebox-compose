import com.android.build.api.dsl.BaseFlavor
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
    id(Plugins.kapt)
}

android {
    compileSdkVersion(AndroidConfig.compileSdk)

    defaultConfig {
        minSdkVersion(AndroidConfig.minSdk)
        targetSdkVersion(AndroidConfig.targetSdk)
        buildToolsVersion(AndroidConfig.buildTools)

        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        buildConfigFieldFromGradleProperty("keyTmdb")
        buildConfigFieldFromGradleProperty("keyTmdbv4")
        buildConfigFieldFromGradleProperty("youTubeKey")
        buildConfigFieldFromGradleProperty("keyTrakTv")
    }

    buildFeatures {
        buildConfig = true

        aidl = false
        prefab = false
        shaders = false

        compose = false

        dataBinding = false
        viewBinding = false
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
    api(Libs.Kotlin.stdlib)
    api(Libs.Coroutines.core)

    api(Libs.Network.OkHttp3.OKHTTP_3)
    api(Libs.Network.OkHttp3.LOGGING_INTERCEPTOR)

    api(Libs.Network.Retrofit.retrofitLib)
    api(Libs.Network.Retrofit.retrofitMoshi)
    implementation(Libs.Network.moshi)
    kapt(Libs.Network.moshiKapt)
}

fun BaseFlavor.buildConfigFieldFromGradleProperty(gradlePropertyName: String) {
    val propertyValue = gradleLocalProperties(rootDir)[gradlePropertyName] as? String
    checkNotNull(propertyValue) { "Gradle property $gradlePropertyName is null" }

    val androidResourceName = "GRADLE_${gradlePropertyName.toSnakeCase()}".toUpperCase()
    buildConfigField("String", androidResourceName, propertyValue)
}

fun String.toSnakeCase() = this.split(Regex("(?=[A-Z])")).joinToString("_") { it.toLowerCase() }

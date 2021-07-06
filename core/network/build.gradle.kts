import com.android.build.api.dsl.BaseFlavor
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(Plugins.androidLibrary)
    kotlin(Plugins.android)
    id(Plugins.kapt)
}

android {
    defaultConfig {
        buildConfigFieldFromGradleProperty("keyTmdb")
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

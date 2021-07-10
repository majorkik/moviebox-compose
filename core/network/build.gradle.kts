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
}

fun BaseFlavor.buildConfigFieldFromGradleProperty(gradlePropertyName: String) {
    val propertyValue = gradleLocalProperties(rootDir)[gradlePropertyName] as? String
    checkNotNull(propertyValue) { "Gradle property $gradlePropertyName is null" }

    val androidResourceName = "GRADLE_${gradlePropertyName.toSnakeCase()}".toUpperCase()
    buildConfigField("String", androidResourceName, propertyValue)
}

fun String.toSnakeCase() = this.split(Regex("(?=[A-Z])")).joinToString("_") { it.toLowerCase() }

package com.majorkik.movieboxcompose

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get

fun Project.android(action: BaseExtension.() -> Unit) =
    (extensions["android"] as BaseExtension).run(action)

fun BaseExtension.configKotlinAndroid() {
    compileSdkVersion(32)

    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

fun BaseExtension.configCompose(composeVersion: String?) {
    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

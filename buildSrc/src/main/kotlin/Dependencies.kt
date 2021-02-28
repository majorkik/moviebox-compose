@file:Suppress("detekt.StringLiteralDuplication")

object Versions {
    // Kotlin
    const val kotlin = "1.4.30"

    // Gradle
    const val androidGradle = "7.0.0-alpha08"

    // Versions
    const val gradleVersions = "0.36.0"

    // Static analysis tools
    const val spotless = "5.10.2"
    const val ktlintJLLeitschuh = "10.0.0"
    const val ktlint = "0.40.0"
    const val detekt = "1.16.0-RC2"

    const val koin = "2.2.2"
}

object Plugins {
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val ktlint = "org.jlleitschuh.gradle.ktlint"
    const val androidApplication = "com.android.application"
    const val androidDynamicFeature = "com.android.dynamic-feature"
    const val androidLibrary = "com.android.library"
    const val gradleVersions = "com.github.ben-manes.versions"
    const val navSafeArgs = "androidx.navigation.safeargs.kotlin"
    const val crashlytics = "com.google.firebase.crashlytics"
    const val gms = "com.google.gms.google-services"
    const val android = "android"
    const val koin = "koin"
    const val spotless = "com.diffplug.spotless"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-alpha08"

    const val jdkDesugar = "com.android.tools:desugar_jdk_libs:1.0.9"

    const val junit = "junit:junit:4.13"

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}"
    }

    object Coroutines {
        private const val version = "1.4.2"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Accompanist {
        private const val version = "0.6.1"

        const val coil = "dev.chrisbanes.accompanist:accompanist-coil:$version"
        const val insets = "dev.chrisbanes.accompanist:accompanist-insets:$version"
    }

    object AndroidX {
        const val vectorDrawable = "androidx.vectordrawable:vectordrawable:1.2.0-alpha02"
        const val annotation = "androidx.annotation:annotation:1.2.0-rc01"

        const val appcompat = "androidx.appcompat:appcompat:1.2.0-rc01"
        const val coreKtx = "androidx.core:core-ktx:1.5.0-beta02"

        const val material = "com.google.android.material:material:1.4.0-alpha01"

        const val multidex = "androidx.multidex:multidex:2.0.1"

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha03"
        }

        object Lifecycle {
            private const val version = "2.3.0"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val viewModelCompose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha02"
        }

        object Compose {
            const val version = "1.0.0-beta01"

            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val test = "androidx.compose.ui:ui-test:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiUtil = "androidx.compose.ui:ui-util:$version"
            const val viewBinding = "androidx.compose.ui:ui-viewbinding:$version"
        }
    }

    object Loggers {
        const val timber = "com.jakewharton.timber:timber:4.7.1"
        const val prettyLogger = "com.orhanobut:logger:2.2.0"
    }

    object Koin {
        const val scope = "org.koin:koin-androidx-scope:${Versions.koin}"
        const val viewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
        const val compose = "org.koin:koin-androidx-compose:${Versions.koin}"
    }

    object Firebase {
        const val firebaseAnalytics = "com.google.firebase:firebase-analytics:18.0.0"
        const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics:17.3.0"
    }

    object Network {
        const val retrofitCoroutinesAdapter =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"

        object Retrofit {
            private const val version = "2.9.0"

            const val retrofit = "com.squareup.retrofit2:retrofit:$version"
            const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:$version"
        }

        object OkHttp3 {
            private const val version = "4.9.0"

            const val OKHTTP_3 = "com.squareup.okhttp3:okhttp:$version"
            const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:$version"
        }
    }

    object Test {
        private const val version = "1.3.0"
        const val core = "androidx.test:core:$version"
        const val rules = "androidx.test:rules:$version"

        object Ext {
            private const val version = "1.1.2"
            const val junit = "androidx.test.ext:junit-ktx:$version"
        }

        const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
    }

    object Others {
        const val stfalconImageViewer = "com.github.stfalcon:stfalcon-imageviewer:1.0.10"
        const val klock = "com.soywiz.korlibs.klock:klock:1.12.0"
    }
}

object Dependency {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Version.kotlin}"

        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0"
    }

    object Coroutines {
        private const val version = "1.5.2"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object AndroidX {
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"

        object Compose {
            const val ui = "androidx.compose.ui:ui:${Version.compose}"
            const val material = "androidx.compose.material:material:${Version.compose}"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
            const val tooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
            const val foundation = "androidx.compose.foundation:foundation:${Version.compose}"
            const val runtime = "androidx.compose.runtime:runtime:${Version.compose}"
        }

        object Lifecycle {
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
        }
    }

    object Loggers {
        const val timber = "com.jakewharton.timber:timber:5.0.1"
        const val prettyLogger = "com.orhanobut:logger:2.2.0"
    }

    object Voyager {
        private const val version = "1.0.0-beta13"

        const val core = "cafe.adriel.voyager:voyager-core:$version"
        const val koin = "cafe.adriel.voyager:voyager-koin:$version"
        const val navigator = "cafe.adriel.voyager:voyager-navigator:$version"
        const val tab = "cafe.adriel.voyager:voyager-tab-navigator:$version"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:4.9.2"
        const val serializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"

        object OkHTTP {
            private const val version = "4.9.2"

            // Must be implemented with implementation (platform (..))
            const val bom = "com.squareup.okhttp3:okhttp-bom:4.9.2"
            const val core = "com.squareup.okhttp3:okhttp"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
        }
    }

    object Koin {
        private const val version = "3.1.3"

        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$version"
        const val tests = "io.insert-koin:koin-test:$version"
    }

    object Accompanist {
        private const val version = "0.21.2-beta"

        const val pager = "com.google.accompanist:accompanist-pager:$version"
        const val pager_indicators = "com.google.accompanist:accompanist-pager-indicators:$version"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
    }

    object Other {
        const val sandwich = "com.github.skydoves:sandwich:1.2.1"
        const val mviOrbit = "org.orbit-mvi:orbit-viewmodel:4.2.0"
        const val coil = "io.coil-kt:coil-compose:1.4.0"
        const val klock = "com.soywiz.korlibs.klock:klock:2.4.8"
    }
}

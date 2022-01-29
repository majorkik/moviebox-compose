object Dependency {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Version.kotlin}"

        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"
    }

    object Coroutines {
        private const val version = "1.6.0"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object AndroidX {
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appcompat = "androidx.appcompat:appcompat:1.4.0"
        const val material = "com.google.android.material:material:1.6.0-alpha01"
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0-rc01"

        object Compose {
            private const val version = "1.1.0-rc01"

            const val compiler = "androidx.compose.compiler:compiler:${Version.composeCompiler}"
            const val ui = "androidx.compose.ui:ui:${version}"
            const val material = "androidx.compose.material:material:${version}"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${version}"
            const val tooling = "androidx.compose.ui:ui-tooling:${version}"
            const val foundation = "androidx.compose.foundation:foundation:${version}"
            const val runtime = "androidx.compose.runtime:runtime:${version}"
        }

        object DataStore {
            private const val version = "1.0.0"

            const val preferences = "androidx.datastore:datastore-preferences:$version"
        }

        object Lifecycle {
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
        }
    }

    object Loggers {
        const val timber = "com.jakewharton.timber:timber:5.0.1"
        const val prettyLogger = "com.orhanobut:logger:2.2.0"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:4.9.2"
        const val serializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"

        object OkHTTP {
            private const val version = "5.0.0-alpha.3"

            // Must be implemented with implementation (platform (..))
            const val bom = "com.squareup.okhttp3:okhttp-bom:$version"
            const val core = "com.squareup.okhttp3:okhttp"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
        }
    }

    object Koin {
        private const val version = "3.1.4"

        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$version"
        const val tests = "io.insert-koin:koin-test:$version"
    }

    object Tests {
        object Kotest {
            const val assertions = "io.kotest:kotest-assertions-core:5.1.0"
        }
    }

    object Accompanist {
        private const val version = "0.22.0-rc"

        const val pager = "com.google.accompanist:accompanist-pager:$version"
        const val pager_indicators = "com.google.accompanist:accompanist-pager-indicators:$version"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val navigationMaterial = "com.google.accompanist:accompanist-navigation-animation:$version"
        const val navigationAnimation = "com.google.accompanist:accompanist-navigation-animation:$version"
        const val systemUIController = "com.google.accompanist:accompanist-systemuicontroller:$version"
    }

    object Other {
        const val sandwich = "com.github.skydoves:sandwich:1.2.2"
        const val mviOrbit = "org.orbit-mvi:orbit-viewmodel:4.3.0"
        const val coil = "io.coil-kt:coil-compose:1.4.0"
        const val klock = "com.soywiz.korlibs.klock:klock:2.4.8"
    }
}

object Dependency {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Version.kotlin}"
    }

    object Coroutines {
        private const val version = "1.5.1"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object AndroidX {
        const val activityCompose = "androidx.activity:activity-compose:1.4.0-rc01"
        const val core = "androidx.core:core-ktx:1.7.0-rc01"
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"

        object Compose {
            const val ui = "androidx.compose.ui:ui:${Version.compose}"
            const val material = "androidx.compose.material:material:${Version.compose}"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
            const val tooling = "androidx.compose.ui:ui-tooling:1.0.4"
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

    object Koin {
        private const val version = "3.1.2"

        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$version"
    }
}

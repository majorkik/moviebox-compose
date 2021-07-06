pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application",
                "com.android.library" ->
                    useModule("com.android.tools.build:gradle:${requested.version}")
                "koin" -> useModule("io.insert-koin:koin-gradle-plugin:${requested.version}")
                "com.diffplug.spotless" ->
                    useModule("com.diffplug.spotless:spotless-plugin-gradle:${requested.version}")
            }
        }
    }
}

rootProject.buildFileName = "build.gradle.kts"

// Main module
include(":app")
// Core modules
include(":core:network", ":core:ui", ":core:base")

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
include(":core_network", ":core_ui")
// Feature modules
include(":feature_navigation", ":feature_discover", ":feature_details", ":feature_collections")
// Feature api modules
include(":feature_movie_api", ":feature_tv_api", ":feature_cast_api", ":feature_discover_api")
// Feature impl modules
include(":feature_movie_impl", ":feature_tv_impl", ":feature_cast_impl", ":feature_discover_impl")

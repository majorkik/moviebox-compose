pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application",
                "com.android.library" ->
                    useModule("com.android.tools.build:gradle:${requested.version}")
                "koin" -> useModule("org.koin:koin-gradle-plugin:${requested.version}")
            }
        }
    }
}

rootProject.buildFileName = "build.gradle.kts"

include(":app")

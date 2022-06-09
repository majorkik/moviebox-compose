pluginManagement {
    includeBuild("composite-build")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "moviebox-compose"

// Main module
include(":app")
// Core modules
include(":core:ui", ":core:common")
// UI
include(
    ":ui:nav-home",
    ":ui:nav-search",
    ":ui:nav-profile",
    ":ui:details"
)
// Features
include(
    ":feature:tmdb:api",
    ":feature:tmdb:impl",
    ":feature:app-preferences:api",
    ":feature:app-preferences:impl",
)

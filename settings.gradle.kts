enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
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
    ":ui:movie-details"
)

// Features
include(
    ":feature:tmdb:api",
    ":feature:tmdb:impl",
    ":feature:app-preferences:api",
    ":feature:app-preferences:impl",
)

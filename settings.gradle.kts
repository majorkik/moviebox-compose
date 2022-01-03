dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}

rootProject.buildFileName = "build.gradle.kts"

rootProject.name = "moviebox-compose"

// Main module
include(":app")

// Core modules
include(":core:ui", ":core:common")

// Navigation
include(":navigation")

// UI
include(
    ":ui:home",
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

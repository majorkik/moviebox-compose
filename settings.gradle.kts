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
include(":core:ui")

// Navigation
include(":navigation")

// UI
include(
    ":ui:home",
    ":ui:movie_details"
)

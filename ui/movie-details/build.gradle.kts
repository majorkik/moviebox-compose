plugins {
    id("moviebox.library.compose")
    alias(libs.plugins.ksp)
}

android {
    libraryVariants.all {
        sourceSets { getByName(name) { kotlin.srcDir("build/generated/ksp/$name/kotlin") } }
    }

    ksp {
        arg("compose-destinations.moduleName", "movie_details")
        arg("compose-destinations.mode", "destinations")
    }
}

dependencies {
    // Submodules
    implementation(projects.core.ui)
    implementation(projects.feature.tmdb.api)

    // Android
    implementation(libs.mvi.orbit)
    implementation(libs.coil)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)
    implementation(libs.compose.destinations.core)

    // Functional programming in Kotlin
    implementation(platform(libs.arrow.bom))
    implementation(libs.arrow.core)

    // DI
    implementation(libs.koin.compose)

    // Utils
    implementation(libs.bundles.logging)
    implementation(libs.klock)

    // KSP
    ksp(libs.compose.destinations.ksp)
}

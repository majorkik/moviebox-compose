plugins {
    id("moviebox.library.compose")
    alias(libs.plugins.ksp)
}

//apply<configuration.AndroidComposePlugin>()

android {
    libraryVariants.all {
        sourceSets { getByName(name) { kotlin.srcDir("build/generated/ksp/$name/kotlin") } }
    }

    ksp {
        arg("compose-destinations.moduleName", "search")
        arg("compose-destinations.mode", "destinations")
    }
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.feature.tmdb.api)

    implementation(libs.bundles.logging)

    implementation(libs.koin.compose)
    implementation(libs.mvi.orbit)

    implementation(libs.coil)

    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    implementation(libs.klock)

    implementation(libs.compose.destinations.core)
    ksp(libs.compose.destinations.ksp)
}

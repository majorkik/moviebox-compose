@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.library")
    kotlin("android")
//    alias(libs.plugins.arrow.analysis.group)
}

composeConfig()

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
}

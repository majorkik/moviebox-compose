plugins {
    id("com.android.library")
}

apply<configuration.AndroidComposePlugin>()

dependencies {
    implementation(projects.core.ui)
    implementation(projects.feature.tmdb.api)
    implementation(projects.feature.appPreferences.api)

    implementation(libs.bundles.logging)

    implementation(libs.koin.compose)
    implementation(libs.mvi.orbit)

    implementation(libs.coil)

    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    implementation(libs.klock)
}

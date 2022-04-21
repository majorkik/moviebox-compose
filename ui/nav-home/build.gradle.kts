plugins { id("com.android.library") }

apply<configuration.AndroidComposePlugin>()

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.feature.tmdb.api)

    implementation(libs.bundles.logging)

    implementation(libs.coroutines.android)

    implementation(libs.koin.compose)
    implementation(libs.mvi.orbit)

    implementation(libs.coil)

    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    implementation(libs.klock)
}

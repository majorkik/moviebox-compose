plugins {
    id("com.android.application")
}

apply<configuration.AndroidApplicationPlugin>()

dependencies {
    implementation(projects.core.ui)
    implementation(projects.navigation)
    implementation(projects.ui.movieDetails)
    implementation(projects.ui.navHome)
    implementation(projects.ui.navProfile)
    implementation(projects.ui.navSearch)
    implementation(projects.feature.tmdb.impl)
    implementation(projects.feature.appPreferences.api)
    implementation(projects.feature.appPreferences.impl)

    implementation(libs.bundles.androidx.ui)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.logging)

    implementation(libs.koin.android)
    implementation(libs.koin.compose)

    implementation(libs.accompanist.navigation.animation)
    implementation(libs.accompanist.navigation.material)
    implementation(libs.accompanist.insets)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.ui.controller)

    testImplementation(libs.koin.test)
}

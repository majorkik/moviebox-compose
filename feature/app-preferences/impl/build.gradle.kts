@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.library")
    kotlin("android")
//    alias(libs.plugins.arrow.analysis.group)
}

androidConfig()

dependencies {
    implementation(projects.feature.appPreferences.api)

    implementation(libs.bundles.logging)

    implementation(libs.koin.android)
    implementation(libs.androidx.datastore.preferences)
}

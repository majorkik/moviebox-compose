plugins {
    id("moviebox.library")
}

android {
    namespace = "com.majorkik.feature.app.preferences.api"
}

dependencies {
    implementation(projects.feature.appPreferences.api)

    implementation(libs.bundles.logging)

    implementation(libs.koin.android)
    implementation(libs.androidx.datastore.preferences)
}

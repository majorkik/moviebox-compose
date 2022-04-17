plugins {
    id("com.android.library")
}

apply<configuration.AndroidPlugin>()

dependencies {
    implementation(projects.feature.appPreferences.api)

    implementation(libs.bundles.logging)

    implementation(libs.koin.android)
    implementation(libs.androidx.datastore.preferences)
}

plugins {
    id("moviebox.library")
//    id("moviebox.code.quality")
}

//linter {
//    isArrowAnalysisEnabled = false
//}

dependencies {
    implementation(projects.feature.appPreferences.api)

    implementation(libs.bundles.logging)

    implementation(libs.koin.android)
    implementation(libs.androidx.datastore.preferences)
}

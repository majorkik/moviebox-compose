plugins {
    id("moviebox.library")
    id("moviebox.code.quality")
}

dependencies {
    implementation(libs.bundles.logging)

    implementation(libs.androidx.datastore.preferences)
    implementation(libs.coroutines.core)
}

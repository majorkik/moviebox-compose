plugins {
    id("moviebox.library")
    id("moviebox.code.quality")
}

android {
    namespace = "com.majorkik.feature.app.preferences.impl"
}

dependencies {
    implementation(libs.bundles.logging)

    implementation(libs.androidx.datastore.preferences)
    implementation(libs.coroutines.core)
}

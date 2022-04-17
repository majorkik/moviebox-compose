plugins {
    id("com.android.library")
}

apply<configuration.AndroidPlugin>()

dependencies {
    implementation(libs.bundles.logging)

    implementation(libs.androidx.datastore.preferences)
    implementation(libs.coroutines.core)
}

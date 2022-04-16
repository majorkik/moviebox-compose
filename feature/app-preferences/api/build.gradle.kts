@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.library")
    kotlin("android")
//    alias(libs.plugins.arrow.analysis.group)
}

androidConfig()

dependencies {
    implementation(libs.bundles.logging)

    implementation(libs.androidx.datastore.preferences)
    implementation(libs.coroutines.core)
}

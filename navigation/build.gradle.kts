@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.library")
    kotlin("android")
//    alias(libs.plugins.arrow.analysis.group)
}

composeConfig()

dependencies {
    implementation(libs.androidx.navigation.compose)
}

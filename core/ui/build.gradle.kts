@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.library")
    kotlin("android")
//    alias(libs.plugins.arrow.analysis.group)
}

composeConfig()

dependencies {
    api(libs.androidx.appcompat)
    api(libs.bundles.compose)
    api(libs.accompanist.insets)
}

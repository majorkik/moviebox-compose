plugins { id("com.android.library") }

apply<configuration.AndroidComposePlugin>()

dependencies {
    api(libs.androidx.appcompat)
    api(libs.bundles.compose)
    api(libs.accompanist.insets)
}

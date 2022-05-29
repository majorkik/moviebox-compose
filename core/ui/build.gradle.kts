plugins {
    id("moviebox.library.compose")
}

//apply<configuration.AndroidComposePlugin>()

dependencies {
    api(libs.androidx.appcompat)
    api(libs.bundles.compose)
    api(libs.accompanist.insets)
}

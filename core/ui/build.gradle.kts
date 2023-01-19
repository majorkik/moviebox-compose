plugins {
    id("moviebox.library.compose")
//    id("moviebox.code.quality")
}

dependencies {
    api(libs.androidx.appcompat)

    api(platform(libs.androidx.compose.bom))
    api(libs.bundles.compose)
    api(libs.accompanist.insets)
}

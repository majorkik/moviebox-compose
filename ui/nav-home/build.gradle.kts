plugins {
    id("com.android.library")
    alias(libs.plugins.ksp)
}

apply<configuration.AndroidComposePlugin>()

android {
    libraryVariants.all {
        sourceSets { getByName(name) { kotlin.srcDir("build/generated/ksp/$name/kotlin") } }
    }

    ksp {
        arg("compose-destinations.moduleName", "home")
        arg("compose-destinations.mode", "destinations")
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.feature.tmdb.api)
    implementation(projects.navigation)

    implementation(libs.bundles.logging)

    implementation(libs.coroutines.android)

    implementation(libs.koin.compose)
    implementation(libs.mvi.orbit)

    implementation(libs.coil)

    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    implementation(libs.klock)

    implementation(libs.compose.destinations.core)
    ksp(libs.compose.destinations.ksp)
}

plugins {
    id("com.android.library")
    id("com.google.devtools.ksp") version "1.6.10-1.0.2"
}

apply<configuration.AndroidComposePlugin>()

android {
    libraryVariants.all {
        sourceSets { getByName(name) { kotlin.srcDir("build/generated/ksp/$name/kotlin") } }
    }

    ksp {
        arg("compose-destinations.moduleName", "profile")
        arg("compose-destinations.mode", "destinations")
    }
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.feature.tmdb.api)
    implementation(projects.feature.appPreferences.api)
    implementation(projects.navigation)

    implementation(libs.bundles.logging)

    implementation(libs.koin.compose)
    implementation(libs.mvi.orbit)

    implementation(libs.coil)

    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    implementation(libs.klock)

    implementation(libs.compose.destinations.core)
    ksp(libs.compose.destinations.ksp)
}

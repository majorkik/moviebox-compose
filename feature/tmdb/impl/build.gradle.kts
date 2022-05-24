plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.6.21"
}

apply<linter.AppDetektPlugin>()

apply<linter.AppKtlintPlugin>()

apply<linter.AppSpotlessPlugin>()

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(projects.feature.tmdb.api)

    implementation(libs.bundles.logging)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.coroutines.core)

    implementation(libs.koin.core)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.bom.core)
    implementation(libs.okhttp.bom.interceptor)

    implementation(platform(libs.arrow.bom))
    implementation(libs.arrow.core)

    implementation(libs.eithernet)

    implementation(libs.serialization.converter)

    implementation(libs.klock)
}

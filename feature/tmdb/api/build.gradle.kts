plugins {
    kotlin("jvm")
    id("moviebox.code.quality")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(projects.core.common)

    implementation(libs.koin.core)

    implementation(platform(libs.arrow.bom))
    implementation(libs.arrow.core)

    implementation(libs.bundles.logging)
    implementation(libs.klock)
}

plugins {
    kotlin("jvm")
    id("moviebox.code.quality")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(projects.core.common)

    implementation(libs.koin.core)

    implementation(platform(libs.arrow.bom))
    implementation(libs.arrow.core)

    implementation(libs.bundles.logging)
    implementation(libs.klock)
}

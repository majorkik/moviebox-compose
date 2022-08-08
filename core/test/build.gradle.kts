plugins {
    kotlin("jvm")
    id("moviebox.code.quality")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(libs.bundles.logging)

    implementation(platform(libs.arrow.bom))
    implementation(libs.arrow.core)

    testImplementation(libs.kotlin.reflect)

    implementation(libs.bundles.kotest)
}

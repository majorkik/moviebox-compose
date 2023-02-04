plugins {
    kotlin("jvm")
}

dependencies {
    api(libs.klock)

    implementation(libs.bundles.logging)

    implementation(platform(libs.arrow.bom))
    implementation(libs.arrow.core)

    testImplementation(libs.kotlin.reflect)

    testImplementation(libs.bundles.kotest)
}

tasks.withType<Test> { useJUnitPlatform() }

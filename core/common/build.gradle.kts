plugins {
    kotlin("jvm")
//    id("moviebox.code.quality")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
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

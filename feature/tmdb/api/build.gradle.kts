@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("jvm")
//    alias(libs.plugins.arrow.analysis.group)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(projects.core.common)

    implementation(libs.bundles.logging)

    implementation(libs.klock)
}

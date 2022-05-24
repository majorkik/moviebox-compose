plugins { kotlin("jvm") }

apply<linter.CodeQualityPlugin>()

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(projects.core.common)

    implementation(platform(libs.arrow.bom))
    implementation(libs.arrow.core)

    implementation(libs.bundles.logging)

    implementation(libs.klock)
}

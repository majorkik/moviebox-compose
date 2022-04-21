plugins { kotlin("jvm") }

apply<linter.CodeQualityPlugin>()

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    api(libs.klock)

    implementation(libs.bundles.logging)

    testImplementation(libs.kotlin.reflect)

    testImplementation(libs.bundles.kotest)
}

tasks.withType<Test> { useJUnitPlatform() }

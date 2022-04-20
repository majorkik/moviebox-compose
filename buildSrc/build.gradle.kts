plugins {
    `kotlin-dsl`
}

// The kotlin-dsl plugin requires a repository to be declared
repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("GradleVersionPlugin") {
            id = "gradle.versions.plugin"
            implementationClass = "dependencymanagment.GradleVersionPlugin"
        }
    }
}

dependencies {
    // The version must match the version in libs.versions.toml
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("com.android.tools.build:gradle:7.1.2")

    implementation("com.github.ben-manes:gradle-versions-plugin:0.42.0")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:10.2.1")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.4.2")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.20.0")
    implementation("io.arrow-kt.analysis.kotlin:io.arrow-kt.analysis.kotlin.gradle.plugin:2.0.2-alpha.18")
}

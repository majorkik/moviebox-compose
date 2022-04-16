plugins {
    `kotlin-dsl`
}

// The kotlin-dsl plugin requires a repository to be declared
repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    // The version must match the version in libs.versions.toml
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("com.android.tools.build:gradle:7.1.2")
    implementation(kotlin("stdlib"))
}

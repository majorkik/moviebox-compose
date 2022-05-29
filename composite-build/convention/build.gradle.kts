plugins {
    `kotlin-dsl`
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

gradlePlugin {
    plugins.register("android-application-compose-plugin") {
        id = "moviebox.application.compose"
        implementationClass = "AndroidApplicationComposePlugin"
    }

    plugins.register("android-application-plugin") {
        id = "moviebox.application"
        implementationClass = "AndroidApplicationPlugin"
    }

    plugins.register("android-library-compose-plugin") {
        id = "moviebox.library.compose"
        implementationClass = "AndroidLibraryComposePlugin"
    }

    plugins.register("android-library-plugin") {
        id = "moviebox.library"
        implementationClass = "AndroidLibraryPlugin"
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.gradle.build)
    implementation(libs.kotlin.stdlib)

//    implementation(libs.detekt.plugin)
//    implementation(libs.spotless.plugin)
//    implementation(libs.ktlint.jlleitschuh.plugin)
//    implementation(libs.gradle.versions.plugin)
//    implementation(libs.arrow.analysis.plugin)
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.gradle.build)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.spotless.plugin)
    }
}

// Remove if swears when using the 'spotless' plugin
//tasks.register<Delete>("clean") {
//    delete(rootProject.buildDir)
//}

plugins {
    kotlin(Plugins.android) version Versions.kotlin apply false
    id(Plugins.androidApplication) version Versions.androidGradle apply false
    id(Plugins.androidLibrary) version Versions.androidGradle apply false
}

// all projects = root project + sub projects
allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
    }
}

subprojects {
    tasks.withType<Test> {
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
    }
}

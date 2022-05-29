buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.gradle.build)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
    }
}

//apply<dependencymanagment.GradleVersionPlugin>()

// Remove if swears when using the 'spotless' plugin
tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}

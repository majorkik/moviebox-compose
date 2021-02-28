import com.android.build.gradle.BaseExtension

plugins {
    id(Plugins.ktlint) version Versions.ktlintJLLeitschuh
    id(Plugins.detekt) version Versions.detekt
    id(Plugins.koin) version Versions.koin
    id(Plugins.gradleVersions) version Versions.gradleVersions
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

    // We want to apply ktlint at all project level because it also checks Gradle config files (*.kts)
    apply(plugin = Plugins.ktlint)
    apply(plugin = "koin")

    // Ktlint configuration for sub-projects
    ktlint {
        // Version of ktlint cmd tool (Ktlint Gradle plugin is just a wrapper for this tool)
        version.set(Versions.ktlint)
        verbose.set(true)
        android.set(true)

        // Uncomment below line and run .\gradlew ktlintCheck to see check ktlint experimental rules
        // enableExperimentalRules.set(true)

        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        }

        filter {
            exclude { element -> element.file.path.contains("generated/") }
        }
    }
}

subprojects {
    tasks.withType<Test> {
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
    }

    apply(plugin = Plugins.detekt)

    detekt {
        config = files("$rootDir/detekt.yml")

        parallel = true

        // By default detekt does not check test source set and gradle specific files, so hey have to be added manually
        input = files(
            "$rootDir/buildSrc",
            "$rootDir/build.gradle.kts",
            "$rootDir/settings.gradle.kts",
            "src/main/kotlin",
            "src/test/kotlin"
        )
    }

    afterEvaluate {
        configureAndroid()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

fun Project.configureAndroid() {
    (project.extensions.findByName("android") as? BaseExtension)?.run {
        sourceSets {
            map { it.java.srcDir("src/${it.name}/kotlin") }
        }
    }
}

// JVM target applied to all Kotlin tasks across all sub-projects
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

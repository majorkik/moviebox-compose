import org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("${Plugin.toolsBuildGradle}:${Version.androidGradle}")
        classpath(kotlin(Plugin.gradlePlugin, version = Version.kotlin))
    }
}

plugins {
    id(Plugin.ktlint) version Version.ktlintJLLeitschuh
    id(Plugin.detekt) version Version.detekt
    id(Plugin.spotless) version Version.spotless
    id(Plugin.gradleVersions) version Version.gradleVersions
    kotlin(Plugin.jvm) version Version.kotlin
    kotlin(Plugin.kotlinSerialization) version Version.kotlin
}

subprojects {
    apply {
        // We want to apply ktlint at all project level because it also checks Gradle config files (*.kts)
        plugin(Plugin.ktlint)
        plugin(Plugin.spotless)
        plugin(Plugin.detekt)
    }

    configureKtlint()
    configureSpotless()
    configDetekt()
}

/**
 * Static code analyzers
 */

fun Project.configDetekt() {
    detekt {
        config = files("$rootDir/detekt.yml")

        parallel = true

        // By default detekt does not check test source set and gradle specific files, so hey have to be added manually
        source = files(
            "$rootDir/buildSrc",
            "$rootDir/build.gradle.kts",
            "$rootDir/settings.gradle.kts",
            "src/main/kotlin",
            "src/test/kotlin"
        )

        autoCorrect = true
    }
}

fun Project.configureSpotless() {
    spotless {
        java {
            target("**/*.java")
            googleJavaFormat().aosp()
            removeUnusedImports()
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }
        kotlin {
            target("**/*.kt")
            // ktlint()
            trimTrailingWhitespace()
            indentWithSpaces()
            endWithNewline()
        }
        format("misc") {
            target("**/*.gradle", "**/*.md", "**/.gitignore")
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }

        kotlinGradle {
            target("*.gradle.kts")
            ktlint()
        }

        format("xml") {
            target("**/*.xml")
            indentWithSpaces()
            trimTrailingWhitespace()
            endWithNewline()
        }
    }
}

fun Project.configureKtlint() {
    // Ktlint configuration for sub-projects
    ktlint {
        // Version of ktlint cmd tool (Ktlint Gradle plugin is just a wrapper for this tool)
        version.set(Version.ktlint)
        debug.set(true)
        verbose.set(true)
        android.set(true)
        outputToConsole.set(true)
        outputColorName.set("BLUE")
        ignoreFailures.set(true)
        enableExperimentalRules.set(true)

        // Uncomment below line and run .\gradlew ktlintCheck to see check ktlint experimental rules
        // enableExperimentalRules.set(true)

        reporters {
            reporter(PLAIN)
            reporter(CHECKSTYLE)
        }

        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

// #Remove if swears when using the 'spotless' plugin
// tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
// }

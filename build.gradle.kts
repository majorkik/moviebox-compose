import com.android.build.gradle.BaseExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN

plugins {
    id(Plugins.ktlint) version Versions.ktlintJLLeitschuh
    id(Plugins.detekt) version Versions.detekt
    id(Plugins.koin) version Versions.koin
    id(Plugins.spotless) version Versions.spotless
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

    apply {
        // We want to apply ktlint at all project level because it also checks Gradle config files (*.kts)
        plugin(Plugins.ktlint)
        plugin(Plugins.spotless)
        plugin(Plugins.detekt)

        plugin(Plugins.koin)
    }

    configureKtlint()
    configureSpotless()
    configDetekt()
}

subprojects {
    tasks.withType<Test> {
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
    }

    afterEvaluate {
        configureAndroid()
    }
}

/**
 * Static code analyzers
 */

fun Project.configDetekt() {
    detekt {
        config = files("$rootDir/detekt.yml")

        parallel = true

        // By default detekt does not check test source set and gradle specific files, so hey have to be added manually
        input = files(
            "$rootDir/buildSrc",
            "$rootDir/build.gradle.kts.kts",
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
        version.set(Versions.ktlint)
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

        kotlinScriptAdditionalPaths {
            include(fileTree("scripts/"))
        }
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
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

// #Remove if swears when using the 'spotless' plugin
// tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
// }

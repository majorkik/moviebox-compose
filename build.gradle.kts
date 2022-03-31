import com.android.build.gradle.BaseExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    val kotlinVersion = libs.versions.kotlin.get()
    val androidGradle = libs.versions.android.gradle.get()

    dependencies {
        classpath(group = "com.android.tools.build", name = "gradle", version = androidGradle)
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
    }
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.ktlint)
    alias(libs.plugins.detekt)
    alias(libs.plugins.spotless)
    alias(libs.plugins.gradle.versions)
//    alias(libs.plugins.arrow.analysis.group)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.jvm)
}

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"

            // Use experimental APIs
            freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
        }
    }
}

subprojects {
    apply {
        // We want to apply ktlint at all project level because it also checks Gradle config files (*.kts)
        plugin(rootProject.libs.plugins.ktlint.get().pluginId)
        plugin(rootProject.libs.plugins.detekt.get().pluginId)
        plugin(rootProject.libs.plugins.spotless.get().pluginId)
    }

    configureKtlint()
    configureSpotless()
    configDetekt()

    afterEvaluate {
        (project.extensions.findByName("android") as? BaseExtension)?.run {
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }
        }
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

tasks.withType<Test> {
    useJUnitPlatform()
}

// #Remove if swears when using the 'spotless' plugin
// tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
// }

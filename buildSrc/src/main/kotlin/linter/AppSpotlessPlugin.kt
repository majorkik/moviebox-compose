package linter

import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AppSpotlessPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply<SpotlessPlugin>()

        configure<SpotlessExtension> {
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
}

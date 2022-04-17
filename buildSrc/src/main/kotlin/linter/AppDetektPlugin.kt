package linter

import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AppDetektPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply<DetektPlugin>()

        configure<DetektExtension> {
            config = files("$rootDir/detekt.yml")

            autoCorrect = true
            parallel = true
            buildUponDefaultConfig = true

            // By default detekt does not check test source set and gradle specific files,
            // so hey have to be added manually
            source = files(
                "$rootDir/buildSrc",
                "$rootDir/build.gradle.kts",
                "$rootDir/settings.gradle.kts",
                "src/main/kotlin",
                "src/main/java"
            )
        }
    }
}

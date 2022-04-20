package linter

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.KtlintPlugin

class AppKtlintPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply<KtlintPlugin>()

        configure<KtlintExtension> {
            debug.set(false)
            verbose.set(true)
            android.set(true)
            outputToConsole.set(true)
            ignoreFailures.set(false)
            enableExperimentalRules.set(true)

            filter {
                exclude("**/generated/**")
                include("**/kotlin/**")
            }
        }
    }
}

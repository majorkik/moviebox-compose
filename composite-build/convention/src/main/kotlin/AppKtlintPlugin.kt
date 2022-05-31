import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.KtlintPlugin
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

class AppKtlintPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply<KtlintPlugin>()

        configure<KtlintExtension> {
            debug.set(true)
            verbose.set(true)
            android.set(true)
            outputToConsole.set(true)
            ignoreFailures.set(false)
            enableExperimentalRules.set(true)
            outputToConsole.set(true)
            outputColorName.set("RED")

            reporters {
                reporter(ReporterType.PLAIN)
                reporter(ReporterType.CHECKSTYLE)
            }

            filter {
                // exclude("**/generated/**")
                exclude {
                    projectDir.toURI().relativize(it.file.toURI()).path.contains("/generated/")
                }
                include("**/kotlin/**")
            }
        }
    }
}

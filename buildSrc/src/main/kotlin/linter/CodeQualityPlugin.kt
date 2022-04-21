package linter

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import arrow.meta.plugin.gradle.AnalysisGradlePlugin

class CodeQualityPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply<AppDetektPlugin>()
        apply<AppKtlintPlugin>()
        apply<AppSpotlessPlugin>()
        apply<AnalysisGradlePlugin>()
    }
}

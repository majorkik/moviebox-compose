import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.kotlin.dsl.getByType
import com.majorkik.movieboxcompose.configureKotlinAndroid

@Suppress("unused")
class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply(plugin = "kotlin-android")

        val extension = extensions.getByType<BaseAppModuleExtension>()

        configureKotlinAndroid(extension)
    }
}

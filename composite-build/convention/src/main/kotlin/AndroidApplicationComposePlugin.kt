import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.majorkik.movieboxcompose.configureAndroidCompose
import com.majorkik.movieboxcompose.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

@Suppress("unused")
class AndroidApplicationComposePlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        pluginManager.apply("com.android.application")
        pluginManager.apply("kotlin-android")

        val extension = extensions.getByType<BaseAppModuleExtension>()

        configureAndroidCompose(extension)
        configureKotlinAndroid(extension)
    }
}

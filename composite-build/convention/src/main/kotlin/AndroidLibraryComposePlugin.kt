import com.android.build.gradle.LibraryExtension
import com.majorkik.movieboxcompose.configureAndroidCompose
import com.majorkik.movieboxcompose.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.getByType

@Suppress("unused")
class AndroidLibraryComposePlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply(plugin = "com.android.library")
        apply(plugin = "kotlin-android")

        val extension = extensions.getByType<LibraryExtension>()

        configureAndroidCompose(extension)
        configureKotlinAndroid(extension)
    }
}

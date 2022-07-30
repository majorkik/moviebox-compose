import com.android.build.gradle.LibraryExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import com.majorkik.movieboxcompose.configureKotlinAndroid

@Suppress("unused")
class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply(plugin = "com.android.library")
        apply(plugin = "kotlin-android")

        val extension = extensions.getByType<LibraryExtension>()

        configureKotlinAndroid(extension)
    }
}

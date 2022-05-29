import com.majorkik.movieboxcompose.android
import com.majorkik.movieboxcompose.catalogs
import com.majorkik.movieboxcompose.configCompose
import com.majorkik.movieboxcompose.configKotlinAndroid
import com.majorkik.movieboxcompose.configKotlinCompileOptions
import com.majorkik.movieboxcompose.getVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

@Suppress("unused")
class AndroidLibraryComposePlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply(plugin = "com.android.library")
        apply(plugin = "kotlin-android")

        val composeVersion = catalogs.getVersion("compose_compiler")

        android {
            configKotlinAndroid()
            configCompose(composeVersion = composeVersion)
        }

        configKotlinCompileOptions()
    }
}

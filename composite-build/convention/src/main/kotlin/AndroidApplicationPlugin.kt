import com.majorkik.movieboxcompose.android
import com.majorkik.movieboxcompose.configKotlinAndroid
import com.majorkik.movieboxcompose.configKotlinCompileOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

@Suppress("unused")
class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply(plugin = "kotlin-android")

        android {
            configKotlinAndroid()
        }

        configKotlinCompileOptions()
    }
}

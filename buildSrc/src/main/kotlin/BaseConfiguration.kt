import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType

fun Project.android(action: BaseExtension.() -> Unit) = (extensions["android"] as BaseExtension).run(action)

fun Project.composeConfig(configuration: BaseExtension.() -> Unit = {}) {
    val catalogs = extensions.getByType<VersionCatalogsExtension>()
    val composeVersion = catalogs.named("libs").findVersion("compose_compiler").get().requiredVersion

    androidConfig {
        buildFeatures.compose = true

        composeOptions {
            kotlinCompilerExtensionVersion = composeVersion
        }

        configuration()
    }
}

fun Project.androidConfig(configuration: BaseExtension.() -> Unit = {}) {
    android {
        compileSdkVersion(AndroidConfig.compileSdk)

        defaultConfig {
            minSdk = AndroidConfig.minSdk
            targetSdk = AndroidConfig.targetSdk
            versionCode = AndroidConfig.versionCode
            versionName = AndroidConfig.versionName

            vectorDrawables {
                useSupportLibrary = AndroidConfig.useSupportLibrary
            }
        }

        configuration()

        compileOptions {
            targetCompatibility = JavaVersion.VERSION_11
            sourceCompatibility = JavaVersion.VERSION_11
        }
    }
}

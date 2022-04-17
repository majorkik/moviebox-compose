package configuration

import AndroidConfig
import BuildType
import BuildTypeDebug
import BuildTypeRelease
import com.android.build.gradle.BaseExtension
import extension.android
import extension.catalogs
import extension.getVersion
import linter.CodeQualityPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply(plugin = "kotlin-android")
        apply<CodeQualityPlugin>()

        val composeVersion = catalogs.getVersion("compose_compiler")

        android {
            defaultConfig {
                applicationId = AndroidConfig.applicationId
            }

            projectDefaultConfig()

            buildTypes {
                getByName(BuildType.RELEASE) {
                    isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
                    isDebuggable = BuildTypeRelease.isDebuggable

                    proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
                }

                getByName(BuildType.DEBUG) {
                    isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
                    isDebuggable = BuildTypeDebug.isDebuggable
                }
            }

            configCompose(composeVersion = composeVersion)
        }

        configCompileOptions()
    }
}

class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply(plugin = "kotlin-android")
        apply<CodeQualityPlugin>()

        android { projectDefaultConfig() }

        configCompileOptions()
    }
}

class AndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) = target.run {
        apply(plugin = "kotlin-android")
        apply<CodeQualityPlugin>()

        android { projectDefaultConfig() }

        configCompileOptions()
    }
}

private fun BaseExtension.projectDefaultConfig() {
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
}

private fun BaseExtension.configCompose(composeVersion: String?) {
    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

private fun Project.configCompileOptions() {
    android {
        compileOptions {
            targetCompatibility = org.gradle.api.JavaVersion.VERSION_11
            sourceCompatibility = org.gradle.api.JavaVersion.VERSION_11
        }
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = org.gradle.api.JavaVersion.VERSION_11.toString()

            freeCompilerArgs = listOf(
                "-Xjvm-default=all",
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xopt-in=kotlinx.coroutines.InternalCoroutinesApi",
                "-Xopt-in=kotlinx.coroutines.FlowPreview",
                "-Xopt-in=kotlin.Experimental"
            )
        }
    }
}

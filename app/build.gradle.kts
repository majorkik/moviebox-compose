import com.android.build.api.dsl.BaseFlavor
import com.android.build.gradle.internal.dsl.DefaultConfig
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.android)
}

android {
    compileSdkVersion(AndroidConfig.compileSdk)

    defaultConfig {
        applicationId = AndroidConfig.applicationId

        minSdkVersion(AndroidConfig.minSdk)
        targetSdkVersion(AndroidConfig.targetSdk)
        buildToolsVersion(AndroidConfig.buildTools)

        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        buildConfigFieldFromGradleProperty("keyTmdb")
        buildConfigFieldFromGradleProperty("keyTmdbv4")
        buildConfigFieldFromGradleProperty("youTubeKey")
        buildConfigFieldFromGradleProperty("keyTrakTv")

        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isDebuggable = BuildTypeRelease.isDebuggable
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isDebuggable = BuildTypeDebug.isDebuggable
        }
    }

    buildFeatures {
        compose = true

        // Disable unused AGP features
//        buildConfig = false
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
    }
}

dependencies {
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Coroutines.android)

    implementation(Libs.Network.OkHttp3.OKHTTP_3)

    implementation(Libs.Network.Retrofit.retrofit)
    implementation(Libs.Network.Retrofit.retrofitMoshi)

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.material)

    implementation(Libs.Koin.koinScope)
    implementation(Libs.Koin.koinFragment)
    implementation(Libs.Koin.koinViewModel)

    implementation(Libs.Loggers.timber)
    implementation(Libs.Loggers.prettyLogger)

    implementation(Libs.AndroidX.annotation)
    implementation(Libs.AndroidX.Activity.activityCompose)
    implementation(Libs.AndroidX.vectorDrawable)

    implementation(Libs.AndroidX.Lifecycle.livedata)
    implementation(Libs.AndroidX.Lifecycle.viewModelCompose)

    implementation(Libs.Others.klock)

    implementation(Libs.Firebase.firebaseAnalytics)
    implementation(Libs.Firebase.firebaseCrashlytics)

    implementation(Libs.Others.stfalconImageViewer)

    implementation(Libs.AndroidX.Compose.layout)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.materialIconsExtended)
    implementation(Libs.AndroidX.Compose.tooling)
    implementation(Libs.AndroidX.Compose.uiUtil)
    implementation(Libs.AndroidX.Compose.runtime)
    implementation(Libs.AndroidX.Compose.runtimeLivedata)
    implementation(Libs.AndroidX.Compose.viewBinding)

    implementation(Libs.Accompanist.coil)
    implementation(Libs.Accompanist.insets)

    androidTestImplementation(Libs.junit)
    androidTestImplementation(Libs.Test.core)
    androidTestImplementation(Libs.Test.espressoCore)
    androidTestImplementation(Libs.Test.rules)
    androidTestImplementation(Libs.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Compose.uiTest)

    // androidx.test is forcing JUnit, 4.12. This forces it to use 4.13
    configurations.configureEach {
        resolutionStrategy {
            force(Libs.junit)
        }
    }
}

tasks.withType(KotlinCompile::class.java).configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

fun BaseFlavor.buildConfigFieldFromGradleProperty(gradlePropertyName: String) {
    val propertyValue =
        com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(rootDir)[gradlePropertyName] as? String
    checkNotNull(propertyValue) { "Gradle property $gradlePropertyName is null" }

    val androidResourceName = "GRADLE_${gradlePropertyName.toSnakeCase()}".toUpperCase()
    buildConfigField("String", androidResourceName, propertyValue)
}

fun String.toSnakeCase() = this.split(Regex("(?=[A-Z])")).joinToString("_") { it.toLowerCase() }

fun DefaultConfig.buildConfigField(name: String, value: Set<String>) {
    // Generates String that holds Java String Array code
    val strValue = value.joinToString(prefix = "{", separator = ",", postfix = "}", transform = {
        "\"$it\""
    })
    buildConfigField("String[]", name, strValue)
}

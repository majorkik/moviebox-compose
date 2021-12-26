object AndroidConfig {
    const val compileSdk = 31
    const val minSdk = 23
    const val targetSdk = 31
    const val buildTools = "32.0.0"

    const val versionCode = 50
    const val versionName = "0.8.1"

    const val applicationId = "com.majorkik.movieboxcompose"

    const val useSupportLibrary = true
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
    val isDebuggable: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
    override val isDebuggable = true
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = true
    override val isDebuggable = false
}

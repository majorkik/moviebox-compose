object AndroidConfig {
    const val compileSdk = 30
    const val minSdk = 23
    const val targetSdk = 30
    const val buildTools = "30.0.2"

    const val versionCode = 44
    const val versionName = "0.6.1"

    const val applicationId = "com.majorkik.movieboxcompose"
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

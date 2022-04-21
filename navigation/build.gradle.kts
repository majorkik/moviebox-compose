plugins { id("com.android.library") }

apply<configuration.AndroidComposePlugin>()

dependencies { implementation(libs.androidx.navigation.compose) }

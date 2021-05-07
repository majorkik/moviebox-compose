package com.majorkik.movieboxcompose.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import com.majorkik.navigation.ui.MovieBoxApp
import com.majorkik.ui.utils.LocalSysUiController
import com.majorkik.ui.utils.SystemUIController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            val systemUiController = remember { SystemUIController(window) }
            CompositionLocalProvider(LocalSysUiController provides systemUiController) {
                MovieBoxApp(finishActivity = { })
            }
        }
    }
}

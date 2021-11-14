package com.majorkik.movieboxcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.majorkik.core.ui.theme.MovieBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(com.majorkik.core.ui.R.style.Theme_MovieBoxCompose)
        super.onCreate(savedInstanceState)

        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            MovieBoxTheme {
                ProvideWindowInsets {
                    MainContainer()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContainer()
}

package com.majorkik.navigation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.majorkik.navigation.domain.NavigationItem
import com.majorkik.navigation.ui.navigation.MovieBoxBottomBar
import com.majorkik.ui.theme.MovieBoxTheme

@Composable
fun MovieBoxApp(finishActivity: () -> Unit) {
    ProvideWindowInsets {
        Surface {
            MovieBoxTheme {
                val tabs = remember { NavigationItem.values() }
                val navController = rememberNavController()

                Scaffold(
                    backgroundColor = Color.White,
                    bottomBar = { BottomBar(navController = navController, tabs = tabs) }
                ) { innerPaddingModifier ->
                    NavGraph(
                        finishActivity = finishActivity,
                        navController = navController,
                        modifier = Modifier.padding(innerPaddingModifier)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomBar(navController: NavController, tabs: Array<NavigationItem>) {
    Box(
        modifier = Modifier
            .padding(all = 16.dp)
            .clip(shape = RoundedCornerShape(12.dp))
    ) {
        MovieBoxBottomBar(navController = navController, tabs = tabs)
    }
}

package com.majorkik.movieboxcompose.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.majorkik.movieboxcompose.Navigation
import com.majorkik.movieboxcompose.currentScreenAsState
import com.majorkik.movieboxcompose.navigation.BottomNavigationBar

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainContainer() {
    val navController = rememberAnimatedNavController()

    Scaffold(backgroundColor = Color.White, bottomBar = {
        val currentSelectedItem by navController.currentScreenAsState()

        BottomNavigationBar(
            selectedNavigation = currentSelectedItem,
            onNavigationSelected = { selected ->
                navController.navigate(selected.route) {
                    launchSingleTop = true
                    restoreState = true

                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

    }) {
        Navigation(navController = navController)
    }
}

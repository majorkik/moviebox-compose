package com.majorkik.movieboxcompose.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.majorkik.movieboxcompose.navigation.Navigation
import com.majorkik.movieboxcompose.navigation.currentScreenAsState
import com.majorkik.movieboxcompose.navigation.BottomNavigationBar

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainContainer() {
    val navController = rememberAnimatedNavController()

    Scaffold(
        backgroundColor = MovieBoxTheme.colors.background,
        bottomBar = {
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
                modifier = Modifier
                    .navigationBarsWithImePadding()
                    .background(MovieBoxTheme.colors.background),
                background = MovieBoxTheme.colors.background
            )
        },
        modifier = Modifier.fillMaxSize()
    ) {
        Navigation(navController = navController)
    }
}

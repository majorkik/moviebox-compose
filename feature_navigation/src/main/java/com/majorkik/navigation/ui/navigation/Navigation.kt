package com.majorkik.navigation.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import com.google.accompanist.insets.navigationBarsHeight
import com.majorkik.navigation.domain.NavigationItem
import com.majorkik.ui.theme.MovieBoxTheme

/**
 * Bottom navigation layout
 *
 * @param navController which manages navigation using NavHost
 * @param tabs an array of possible tabs on the bottom navigation
 */

@Composable
fun MovieBoxBottomBar(navController: NavController, tabs: Array<NavigationItem>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE) ?: NavigationItem.HOME.route

    val routes = remember { NavigationItem.values().map { it.route } }

    if (currentRoute in routes) {
        BottomNavigation(
            Modifier.navigationBarsHeight(additional = 56.dp),
            backgroundColor = MovieBoxTheme.colors.background
        ) {
            tabs.forEach { tab ->
                BottomNavigationItem(
                    icon = { Icon(painterResource(tab.icon), contentDescription = null) },
                    selected = currentRoute == tab.route,
                    onClick = {
                        if (tab.route != currentRoute) {
                            navController.navigate(tab.route) {
                                popUpTo = navController.graph.startDestination
                                launchSingleTop = true
                            }
                        }
                    },
                    alwaysShowLabel = false,
                    selectedContentColor = MovieBoxTheme.colors.primary,
                    unselectedContentColor = MovieBoxTheme.colors.main
                )
            }
        }
    }
}

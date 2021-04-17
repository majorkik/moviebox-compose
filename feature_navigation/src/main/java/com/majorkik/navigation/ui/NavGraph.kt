package com.majorkik.navigation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

/**
 * Destinations used in the ([com.majorkik.navigation.ui.MovieBoxApp]).
 */
object MainDestinations {
    const val HOME_ROUTE = "home"
    const val DISCOVER_ROUTE = "discover"
    const val PROFILE_ROUTE = "profile"
}

/**
 * Manages NavHost and internally defined screens.
 */

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    finishActivity: () -> Unit = {},
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.HOME_ROUTE) {
            // Intercept back in Onboarding: make it finish the activity
            BackHandler {
                finishActivity()
            }
        }

        composable(route = MainDestinations.DISCOVER_ROUTE) { backStackEntry ->
        }

        composable(route = MainDestinations.PROFILE_ROUTE) { backStackEntry ->
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController)

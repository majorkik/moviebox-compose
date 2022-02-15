package com.majorkik.movieboxcompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import com.majorkik.navigation.Screen
import com.majorkik.navigation.StackScreen
import com.majorkik.ui.nav.home.ui.NavHomeScreen
import com.majorkik.ui.nav.profile.ui.NavProfileScreen
import com.majorkik.ui.nav.search.ui.NavSearchScreen

@ExperimentalAnimationApi
@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {
    AnimatedNavHost(
        navController = navController,
        startDestination = StackScreen.Home.route,
        modifier = modifier
    ) {
        navigation(
            route = StackScreen.Home.route,
            startDestination = Screen.Home.createRoute(StackScreen.Home)
        ) {
            composable(route = Screen.Home.createRoute(StackScreen.Home)) {
                NavHomeScreen()
            }
        }

        navigation(
            route = StackScreen.Search.route,
            startDestination = Screen.Search.createRoute(StackScreen.Search)
        ) {
            composable(route = Screen.Search.createRoute(StackScreen.Search)) {
                NavSearchScreen()
            }
        }

        navigation(
            route = StackScreen.Profile.route,
            startDestination = Screen.Profile.createRoute(StackScreen.Profile)
        ) {
            composable(route = Screen.Profile.createRoute(StackScreen.Profile)) {
                NavProfileScreen()
            }
        }
    }
}

/**
 * Adds an [NavController.OnDestinationChangedListener] to this [NavController] and updates the
 * returned [State] which is updated as the destination changes.
 */
@Stable
@Composable
internal fun NavController.currentScreenAsState(): State<StackScreen> {
    val selectedItem = remember { mutableStateOf<StackScreen>(StackScreen.Home) }

    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            when {
                destination.hierarchy.any { it.route == StackScreen.Home.route } -> {
                    selectedItem.value = StackScreen.Home
                }
                destination.hierarchy.any { it.route == StackScreen.Search.route } -> {
                    selectedItem.value = StackScreen.Search
                }
                destination.hierarchy.any { it.route == StackScreen.Profile.route } -> {
                    selectedItem.value = StackScreen.Profile
                }
            }
        }
        addOnDestinationChangedListener(listener)

        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }

    return selectedItem
}

package com.majorkik.movieboxcompose.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.majorkik.core.ui.theme.MovieBoxTheme
import com.ramcosta.composedestinations.spec.NavGraphSpec

@Composable
fun BottomNavigation(navController: NavController) {
    val currentSelectedItem by navController.currentScreenAsState()

    BottomNavigation(
        backgroundColor = MovieBoxTheme.colors.background,
        modifier = Modifier
            .navigationBarsPadding()
            .imePadding()
            .background(MovieBoxTheme.colors.background),
        elevation = 0.dp
    ) {
        BottomNavigationItems.forEach { item ->
            val isSelected = currentSelectedItem == item.screen

            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(item.screen.route) {
                        launchSingleTop = true
                        restoreState = true

                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                },
                icon = {
                    BottomNavigationIcon(item = item, isSelected = isSelected)
                }
            )
        }
    }
}

data class BottomNavigationItem(
    val screen: NavGraphSpec,
    @DrawableRes val iconResId: Int,
    @DrawableRes val selectedIconResId: Int? = null,
)

val BottomNavigationItems = listOf(
    BottomNavigationItem(
        screen = NavGraphs.home,
        iconResId = com.majorkik.core.ui.R.drawable.ic_tv_black_24,
        selectedIconResId = com.majorkik.core.ui.R.drawable.ic_tv_black_24
    ),

    BottomNavigationItem(
        screen = NavGraphs.search,
        iconResId = com.majorkik.core.ui.R.drawable.ic_search_black_24,
        selectedIconResId = com.majorkik.core.ui.R.drawable.ic_search_black_24
    ),

    BottomNavigationItem(
        screen = NavGraphs.profile,
        iconResId = com.majorkik.core.ui.R.drawable.ic_profile_black_24,
        selectedIconResId = com.majorkik.core.ui.R.drawable.ic_profile_black_24
    ),
)

@Composable
fun BottomNavigationIcon(item: BottomNavigationItem, isSelected: Boolean) {
    Icon(
        painter = painterResource(id = item.iconResId),
        contentDescription = null,
        tint = if (isSelected) MovieBoxTheme.colors.primary else MovieBoxTheme.colors.backgroundReverse
    )
}

/**
 * Adds an [NavController.OnDestinationChangedListener] to this [NavController] and updates the
 * returned [State] which is updated as the destination changes.
 */
@Stable
@Composable
private fun NavController.currentScreenAsState(): State<NavGraphSpec> {
    val selectedItem = remember { mutableStateOf(NavGraphs.home) }

    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            selectedItem.value = destination.navGraph()
        }

        addOnDestinationChangedListener(listener)

        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }

    return selectedItem
}

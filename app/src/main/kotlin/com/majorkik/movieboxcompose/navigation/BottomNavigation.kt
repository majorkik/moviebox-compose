package com.majorkik.movieboxcompose.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.google.accompanist.insets.navigationBarsPadding
import com.majorkik.navigation.StackScreen
import com.majorkik.core.ui.R as UIRes

private data class BottomNavigationItem(
    val screen: StackScreen,
    @DrawableRes val iconResId: Int,
    @DrawableRes val selectedIconResId: Int? = null,
)

private val BottomNavigationItems = listOf(
    BottomNavigationItem(
        screen = StackScreen.Home,
        iconResId = UIRes.drawable.ic_dark_mode_black_24,
        selectedIconResId = UIRes.drawable.ic_light_mode_black_24dp
    ),

    BottomNavigationItem(
        screen = StackScreen.Search,
        iconResId = UIRes.drawable.ic_dark_mode_black_24,
        selectedIconResId = UIRes.drawable.ic_light_mode_black_24dp
    ),

    BottomNavigationItem(
        screen = StackScreen.Profile,
        iconResId = UIRes.drawable.ic_dark_mode_black_24,
        selectedIconResId = UIRes.drawable.ic_light_mode_black_24dp
    ),
)

@Composable
internal fun BottomNavigationBar(
    selectedNavigation: StackScreen,
    onNavigationSelected: (StackScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    BottomNavigation(modifier = modifier.navigationBarsPadding()) {
        BottomNavigationItems.forEach { item ->
            BottomNavigationItem(
                selected = selectedNavigation == item.screen,
                onClick = { onNavigationSelected(item.screen) },
                icon = {
                    BottomNavigationIcon(item)
                }
            )
        }
    }
}

@Composable
private fun BottomNavigationIcon(item: BottomNavigationItem) {
    Icon(
        painter = painterResource(id = item.iconResId),
        contentDescription = null
    )
}

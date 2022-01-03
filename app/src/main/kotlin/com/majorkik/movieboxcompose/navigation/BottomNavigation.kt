package com.majorkik.movieboxcompose.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.majorkik.core.ui.theme.MovieBoxTheme
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
        iconResId = UIRes.drawable.ic_tv_black_24,
        selectedIconResId = UIRes.drawable.ic_tv_black_24
    ),

    BottomNavigationItem(
        screen = StackScreen.Search,
        iconResId = UIRes.drawable.ic_search_black_24,
        selectedIconResId = UIRes.drawable.ic_search_black_24
    ),

    BottomNavigationItem(
        screen = StackScreen.Profile,
        iconResId = UIRes.drawable.ic_profile_black_24,
        selectedIconResId = UIRes.drawable.ic_profile_black_24
    ),
)

@Composable
internal fun BottomNavigationBar(
    selectedNavigation: StackScreen,
    onNavigationSelected: (StackScreen) -> Unit,
    modifier: Modifier = Modifier,
    background: Color = Color.White
) {
    BottomNavigation(backgroundColor = background, modifier = modifier, elevation = 0.dp) {
        BottomNavigationItems.forEach { item ->
            val isSelected = selectedNavigation == item.screen

            BottomNavigationItem(
                selected = isSelected,
                onClick = { onNavigationSelected(item.screen) },
                icon = {
                    BottomNavigationIcon(item = item, isSelected = isSelected)
                }
            )
        }
    }
}

@Composable
private fun BottomNavigationIcon(item: BottomNavigationItem, isSelected: Boolean) {
    Icon(
        painter = painterResource(id = item.iconResId),
        contentDescription = null,
        tint = if (isSelected) MovieBoxTheme.colors.primary else MovieBoxTheme.colors.backgroundReverse
    )
}

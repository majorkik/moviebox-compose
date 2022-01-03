package com.majorkik.navigation

sealed class StackScreen(val route: String) {
    object Home : StackScreen(route = "home")
    object Search : StackScreen(route = "search")
    object Profile : StackScreen(route = "profile")
}

sealed class Screen(val route: String) {
    fun createRoute(root: StackScreen) = "${root.route}/$route"

    object Home : Screen(route = "home")
    object Search : Screen(route = "search")
    object Profile : Screen(route = "profile")
}

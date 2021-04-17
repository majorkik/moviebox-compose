package com.majorkik.navigation.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.majorkik.navigation.R
import com.majorkik.navigation.domain.CoursesDestinations.DISCOVER_ROUTE
import com.majorkik.navigation.domain.CoursesDestinations.HOME_ROUTE
import com.majorkik.navigation.domain.CoursesDestinations.PROFILE_ROUTE

enum class NavigationItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {
    HOME(R.string.nav_title_home, R.drawable.ic_nav_home, HOME_ROUTE),
    DISCOVER(R.string.nav_title_discover, R.drawable.ic_nav_tune, DISCOVER_ROUTE),
    PROFILE(R.string.nav_title_profile, R.drawable.ic_nav_profile, PROFILE_ROUTE)
}

/**
 * Destinations used in the ([com.majorkik.navigation.ui.MovieBoxApp]).
 */
private object CoursesDestinations {
    const val HOME_ROUTE = "home"
    const val DISCOVER_ROUTE = "discover"
    const val PROFILE_ROUTE = "profile"
}

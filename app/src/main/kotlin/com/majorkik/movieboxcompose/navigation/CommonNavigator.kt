package com.majorkik.movieboxcompose.navigation

import androidx.navigation.NavController
import com.majorkik.ui.movie.details.ui.destinations.MovieDetailsScreenDestination
import com.majorkik.ui.nav.home.ui.NavHomeNavigator
import com.ramcosta.composedestinations.dynamic.within
import com.ramcosta.composedestinations.navigation.navigateTo
import com.ramcosta.composedestinations.spec.NavGraphSpec

class CommonNavigator(
    private val navGraph: NavGraphSpec,
    private val navController: NavController
) : NavHomeNavigator {
    override fun navigateUp() {
        navController.navigateUp()
    }

    override fun openMovieDetails(movieId: Int) {
        val direction = MovieDetailsScreenDestination(movieId = movieId) within navGraph
        navController.navigateTo(direction)
    }
}

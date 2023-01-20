package com.majorkik.movieboxcompose.navigation

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.ramcosta.composedestinations.spec.NavGraphSpec

@Suppress("TooGenericExceptionThrown")
fun NavDestination.navGraph(): NavGraphSpec {
    hierarchy.forEach { destination ->
        NavGraphs.root.nestedNavGraphs.forEach { navGraph ->
            if (destination.route == navGraph.route) {
                return navGraph
            }
        }
    }

    throw RuntimeException("Unknown nav graph for destination $route")
}

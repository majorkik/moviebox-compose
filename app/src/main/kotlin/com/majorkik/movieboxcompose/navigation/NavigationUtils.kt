package com.majorkik.movieboxcompose.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.majorkik.movieboxcompose.logger
import com.ramcosta.composedestinations.spec.NavGraphSpec

fun ArrayDeque<NavBackStackEntry>.printToLog(prefix: String = "stack") {
    val stack = toMutableList()
        .map { it.destination.route }
        .toTypedArray()
        .contentToString()

    logger.info { "$prefix = $stack" }
}

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

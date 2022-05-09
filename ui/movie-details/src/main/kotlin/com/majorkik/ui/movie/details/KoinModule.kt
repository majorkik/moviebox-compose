package com.majorkik.ui.movie.details

import androidx.navigation.NavBackStackEntry
import com.majorkik.ui.movie.details.ui.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieDetailsModule = module {
    viewModel { (navBackStackEntry: NavBackStackEntry) ->
        MovieDetailsViewModel(navBackStackEntry = navBackStackEntry, repository = get())
    }
}

package com.majorkik.ui.details

import androidx.navigation.NavBackStackEntry
import com.majorkik.ui.details.ui.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieDetailsModule = module {
    viewModel { (navBackStackEntry: NavBackStackEntry) ->
        MovieDetailsViewModel(navBackStackEntry = navBackStackEntry, repository = get())
    }
}

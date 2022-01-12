package com.majorkik.ui.nav.home

import com.majorkik.ui.nav.home.ui.NavHomeViewModelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiNavHome = module {
    viewModel { NavHomeViewModelViewModel(genresRepository = get()) }
}

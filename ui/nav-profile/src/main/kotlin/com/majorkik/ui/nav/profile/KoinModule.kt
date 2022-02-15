package com.majorkik.ui.nav.profile

import com.majorkik.ui.nav.profile.ui.NavProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiNavProfile = module {
    viewModel { NavProfileViewModel(appPreferences = get()) }
}

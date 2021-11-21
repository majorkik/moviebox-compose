package com.majorkik.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    object Home : SharedScreen()
}

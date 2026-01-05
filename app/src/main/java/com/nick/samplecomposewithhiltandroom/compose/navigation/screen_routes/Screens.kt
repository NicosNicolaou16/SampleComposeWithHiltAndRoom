package com.nick.samplecomposewithhiltandroom.compose.navigation.screen_routes

import androidx.navigation3.runtime.NavKey

data object LauncherScreen : NavKey

data object ShipsScreen : NavKey

data class ShipDetailsScreen(
    val shipId: String
) : NavKey
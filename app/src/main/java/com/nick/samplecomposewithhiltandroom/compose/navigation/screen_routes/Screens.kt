package com.nick.samplecomposewithhiltandroom.compose.navigation.screen_routes

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object LauncherScreen : NavKey

@Serializable
data object ShipsScreen : NavKey

@Serializable
data class ShipDetailsScreen(
    val shipId: String
) : NavKey
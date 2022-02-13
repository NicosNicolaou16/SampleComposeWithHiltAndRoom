package com.nick.samplecomposewithhiltandroom.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nick.samplecomposewithhiltandroom.ui.launcher_screen.LauncherScreen
import com.nick.samplecomposewithhiltandroom.ui.ship_details_screen.ShipDetailsScreen
import com.nick.samplecomposewithhiltandroom.ui.ship_details_screen.SHIP_ID_KEY
import com.nick.samplecomposewithhiltandroom.ui.ships_screen.ShipsScreen
import com.nick.samplecomposewithhiltandroom.utils.screen_routes.ScreenRoutes
import com.nick.samplecomposewithhiltandroom.utils.screen_routes.ScreenRoutes.SHIP_DETAILS_SCREEN

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.LAUNCHER_SCREEN
    ) {
        composable(ScreenRoutes.LAUNCHER_SCREEN) {
            LauncherScreen(navController = navController)
        }
        composable(ScreenRoutes.SHIPS_SCREEN) {
            ShipsScreen(navController)
        }
        composable("${SHIP_DETAILS_SCREEN}/{$SHIP_ID_KEY}", arguments = listOf(
            navArgument(SHIP_ID_KEY) {
                type = NavType.StringType
                defaultValue = null
                nullable = true
            })) {
            ShipDetailsScreen(shipId = it.arguments?.getString(SHIP_ID_KEY, null)!!)
        }
    }
}

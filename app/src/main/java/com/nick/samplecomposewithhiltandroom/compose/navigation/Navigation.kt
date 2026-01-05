package com.nick.samplecomposewithhiltandroom.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.nick.samplecomposewithhiltandroom.compose.launcher_screen.LauncherScreen
import com.nick.samplecomposewithhiltandroom.compose.navigation.navigation_3.Navigator
import com.nick.samplecomposewithhiltandroom.compose.navigation.navigation_3.navigationState
import com.nick.samplecomposewithhiltandroom.compose.ships_screen.ShipsScreen
import com.nick.samplecomposewithhiltandroom.compose.navigation.screen_routes.LauncherScreen
import com.nick.samplecomposewithhiltandroom.compose.navigation.screen_routes.ShipDetailsScreen
import com.nick.samplecomposewithhiltandroom.compose.navigation.screen_routes.ShipsScreen

@Composable
fun Navigation() {
    // this is the state of the navigation
    val navigationState = LauncherScreen.navigationState()

    // this is the navigator
    val navigator = remember { Navigator(navigationState) }

    NavDisplay(
        backStack = navigationState.stacksInUse,
        onBack = {
            navigator.goBack()
        },
        entryProvider = entryProvider {
            entry<LauncherScreen>(
            ) {
                LauncherScreen(
                    navigator = navigator
                )
            }

            entry<ShipsScreen> {
                ShipsScreen(
                    navigator = navigator
                )
            }

            entry<ShipDetailsScreen> {
                com.nick.samplecomposewithhiltandroom.compose.ship_details_screen.ShipDetailsScreen(
                    shipId = it.shipId,
                )
            }
        })
}

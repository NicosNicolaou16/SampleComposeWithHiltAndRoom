package com.nick.samplecomposewithhiltandroom.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nick.samplecomposewithhiltandroom.R
import com.nick.samplecomposewithhiltandroom.ui.launcher_screen.LauncherScreen
import com.nick.samplecomposewithhiltandroom.ui.generic_compose_views.CustomToolbar
import com.nick.samplecomposewithhiltandroom.ui.ships_screen.ListOfShipsScreen
import com.nick.samplecomposewithhiltandroom.ui.theme.SampleComposeWithHiltAndRoomTheme
import com.nick.samplecomposewithhiltandroom.utils.screen_routes.ScreenRoutes.LAUNCHER_SCREEN
import com.nick.samplecomposewithhiltandroom.utils.screen_routes.ScreenRoutes.SHIPS_SCREEN
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleComposeWithHiltAndRoomTheme {
                val scaffoldState: ScaffoldState = rememberScaffoldState()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        CustomToolbar(R.string.list_of_ships)
                    },
                    modifier = Modifier.fillMaxSize(),
                    content = {
                       Navigation()
                    })
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = LAUNCHER_SCREEN
    ) {
        composable(LAUNCHER_SCREEN) {
            LauncherScreen(navController = navController)
        }
        composable(SHIPS_SCREEN) {
            ListOfShipsScreen()
        }
    }
}

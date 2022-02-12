package com.nick.samplecomposewithhiltandroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nick.samplecomposewithhiltandroom.ui.CustomToolbar
import com.nick.samplecomposewithhiltandroom.ui.ListOfShips
import com.nick.samplecomposewithhiltandroom.ui.LoaderAndErrorHandler
import com.nick.samplecomposewithhiltandroom.ui.theme.SampleComposeWithHiltAndRoomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeRequest()
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
                        InitComposes()
                    })
            }
        }
    }

    private fun makeRequest() {
        val mainActivityViewModel by viewModels<MainActivityViewModel>()
        mainActivityViewModel.requestForShipsData()
    }

    @Composable
    private fun InitComposes() {
        LoaderAndErrorHandler()
        ListOfShips()
    }
}
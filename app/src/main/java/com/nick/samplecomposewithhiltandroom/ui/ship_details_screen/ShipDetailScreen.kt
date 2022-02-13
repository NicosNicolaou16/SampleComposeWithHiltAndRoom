package com.nick.samplecomposewithhiltandroom.ui.ship_details_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.nick.samplecomposewithhiltandroom.R
import com.nick.samplecomposewithhiltandroom.ui.generic_compose_views.CustomToolbar
import com.nick.samplecomposewithhiltandroom.ui.generic_compose_views.LoaderAndErrorHandler

const val SHIP_ID_KEY = "ship_id_key"

@Composable
internal fun ShipDetailsScreen(
    shipId: String,
    shipDetailsViewModel: ShipDetailsViewModel = hiltViewModel()
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CustomToolbar(R.string.list_of_ships)
        },
        content = {
            LoaderAndErrorHandler(baseViewModel = shipDetailsViewModel)
            ShipDetailsView(shipId)
        })
}

@Composable
private fun ShipDetailsView(
    shipId: String,
    shipDetailsViewModel: ShipDetailsViewModel = hiltViewModel()
) {
    shipDetailsViewModel.queryShipById(shipId)
    val shipData = shipDetailsViewModel.shipDetails.collectAsState().value
    if(shipData.ship_name != null) {
        Box {
            Text(text = shipData.ship_name!!)
        }
    }
}
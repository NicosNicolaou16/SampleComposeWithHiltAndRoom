package com.nick.samplecomposewithhiltandroom.ui.ship_details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import coil.request.CachePolicy
import coil.size.Scale
import com.nick.samplecomposewithhiltandroom.R
import com.nick.samplecomposewithhiltandroom.ui.generic_compose_views.CustomToolbar
import com.nick.samplecomposewithhiltandroom.ui.generic_compose_views.LoaderAndErrorHandler
import com.nick.samplecomposewithhiltandroom.utils.extensions.getProgressDrawable
import kotlinx.coroutines.Dispatchers

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
    val context = LocalContext.current
    shipDetailsViewModel.queryShipById(shipId)
    val shipData = shipDetailsViewModel.shipDetails.collectAsState().value
    if(shipData.image != null && shipData.ship_name != null && shipData.ship_type != null) {
        Box(contentAlignment = Alignment.TopCenter) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = rememberImagePainter(
                        data = shipData.image,
                        builder = {
                            scale(Scale.FIT)
                            placeholder(getProgressDrawable(context))
                            error(R.drawable.ic_baseline_image_24)
                            fallback(R.drawable.ic_baseline_image_24)
                            memoryCachePolicy(CachePolicy.ENABLED)
                            dispatcher(Dispatchers.Default)
                        }),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 150.dp)
                )
                Text(
                    text = shipData.ship_name!!,
                    style = TextStyle(fontSize = 15.sp, textAlign = TextAlign.Center),
                    color = Color.Black,
                )
                Text(
                    text = shipData.ship_type!!,
                    style = TextStyle(fontSize = 15.sp, textAlign = TextAlign.Center),
                    color = Color.Black,
                )
            }
        }
    }
}
package com.nick.samplecomposewithhiltandroom.compose.ship_details_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Scale
import com.nick.samplecomposewithhiltandroom.R
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsEntity
import com.nick.samplecomposewithhiltandroom.compose.generic_compose_views.CustomToolbar
import com.nick.samplecomposewithhiltandroom.compose.generic_compose_views.ShowDialog
import com.nick.samplecomposewithhiltandroom.compose.generic_compose_views.StartDefaultLoader
import com.nick.samplecomposewithhiltandroom.compose.ships_screen.models.ShipDetailsUi
import com.nick.samplecomposewithhiltandroom.utils.extensions.getProgressDrawable
import kotlinx.coroutines.Dispatchers

const val SHIP_ID_KEY = "ship_id_key"

@Composable
internal fun ShipDetailsScreen(
    shipId: String,
    shipDetailsViewModel: ShipDetailsViewModel = hiltViewModel()
) {
    shipDetailsViewModel.queryShipById(shipId)
    val shipData = shipDetailsViewModel.shipDetails.collectAsState().value
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CustomToolbar(shipData.shipName ?: "")
        },
        content = { paddingValue ->
            val isLoading = shipDetailsViewModel.loading.observeAsState(initial = false).value
            if (isLoading) StartDefaultLoader()
            val error = shipDetailsViewModel.error.observeAsState(initial = null).value
            if (error != null) ShowDialog(title = error, message = "")
            ShipDetailsView(shipData, paddingValue)
        })
}

@Composable
private fun ShipDetailsView(
    shipData: ShipDetailsUi,
    paddingValues: PaddingValues
) {
    val context = LocalContext.current
    Box(contentAlignment = Alignment.TopCenter) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = ImageRequest.Builder(context = context).apply {
                    data(shipData.image)
                    scale(Scale.FIT)
                    placeholder(getProgressDrawable(context))
                    error(R.drawable.ic_baseline_image_24)
                    fallback(R.drawable.ic_baseline_image_24)
                    memoryCachePolicy(CachePolicy.ENABLED)
                    dispatcher(Dispatchers.Default)
                }.build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 300.dp)
            )
            Text(
                text = shipData.shipName ?: "",
                style = TextStyle(
                    fontSize = 21.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White,
            )
            Text(
                text = shipData.shipType ?: "",
                style = TextStyle(
                    fontSize = 21.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White,
            )
        }
    }
}
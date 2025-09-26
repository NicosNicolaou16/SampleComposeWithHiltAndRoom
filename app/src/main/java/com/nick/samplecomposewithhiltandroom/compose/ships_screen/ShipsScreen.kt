package com.nick.samplecomposewithhiltandroom.compose.ships_screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Scale
import com.nick.samplecomposewithhiltandroom.R
import com.nick.samplecomposewithhiltandroom.compose.generic_compose_views.CustomToolbar
import com.nick.samplecomposewithhiltandroom.compose.generic_compose_views.ShowDialog
import com.nick.samplecomposewithhiltandroom.compose.generic_compose_views.StartDefaultLoader
import com.nick.samplecomposewithhiltandroom.compose.ships_screen.models.ShipsUi
import com.nick.samplecomposewithhiltandroom.utils.extensions.getProgressDrawable
import com.nick.samplecomposewithhiltandroom.utils.screen_routes.Screens.SHIP_DETAILS_SCREEN
import kotlinx.coroutines.Dispatchers

@Composable
internal fun ShipsScreen(navController: NavController) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CustomToolbar(R.string.list_of_ships)
        },
        content = { paddingValue ->
            ListOfShips(navController = navController, paddingValues = paddingValue)
        })
}

@Composable
private fun ListOfShips(
    navController: NavController,
    paddingValues: PaddingValues,
    shipsViewModel: ShipsViewModel = hiltViewModel()
) {
    val isLoading = shipsViewModel.loading.observeAsState(initial = false).value
    if (isLoading) StartDefaultLoader()
    val error = shipsViewModel.error.observeAsState(initial = "").value
    if (error != null && error.isNotEmpty()) ShowDialog(
        title = stringResource(id = R.string.error),
        message = error
    )
    val context = LocalContext.current
    val shipModelList =
        shipsViewModel.shipsEntityStateFlow.collectAsState(initial = mutableListOf()).value
    LazyColumn {
        items(shipModelList, key = { shipModel -> shipModel.id }) {
            ShipItemView(shipsUi = it) { selectedShipDataValue ->
                Toast.makeText(
                    context,
                    selectedShipDataValue.shipName.toString(),
                    Toast.LENGTH_SHORT
                ).show()
                navController.navigate(SHIP_DETAILS_SCREEN + "/${selectedShipDataValue.id}")
            }
        }
    }
}

@Composable
private fun ShipItemView(
    shipsUi: ShipsUi,
    listener: (ShipsUi) -> Unit
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .height(125.dp)
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                listener(shipsUi)
            },
        elevation = 3.dp,
        shape = RoundedCornerShape(9.dp),
        backgroundColor = Color.DarkGray
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = context).apply {
                    data(shipsUi.image)
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
                    .fillMaxHeight()
                    .width(width = 150.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .wrapContentWidth()
                    .fillMaxHeight()
                    .padding(start = 15.dp),
            ) {
                Column {
                    Text(
                        shipsUi.shipName.toString(),
                        style = TextStyle(fontSize = 15.sp, textAlign = TextAlign.Center),
                        color = Color.White,
                    )
                    Text(
                        shipsUi.shipType.toString(),
                        style = TextStyle(fontSize = 15.sp, textAlign = TextAlign.Center),
                        color = Color.White,
                    )
                }
            }
        }
    }
}
package com.nick.samplecomposewithhiltandroom.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.request.CachePolicy
import coil.size.Scale
import com.nick.samplecomposewithhiltandroom.MainActivityViewModel
import com.nick.samplecomposewithhiltandroom.R
import com.nick.samplecomposewithhiltandroom.room_database.ships.ShipsModel
import com.nick.samplecomposewithhiltandroom.utils.extensions.getProgressDrawable
import kotlinx.coroutines.Dispatchers

@Composable
fun ListOfShips(mainActivityViewModel: MainActivityViewModel = viewModel()) {
    val context = LocalContext.current
    val shipModelList =
        mainActivityViewModel.shipsModelStateFlow.collectAsState(initial = mutableListOf()).value
    LazyColumn {
        items(shipModelList) {
            ShipItemView(shipModel = it) { selectedShipDataValue ->
                Toast.makeText(
                    context,
                    selectedShipDataValue.ship_name.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

@Composable
private fun ShipItemView(
    shipModel: ShipsModel,
    listener: (ShipsModel) -> Unit
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .height(125.dp)
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                listener(shipModel)
            },
        elevation = 9.dp,
        shape = RoundedCornerShape(9.dp),
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(
                    data = shipModel.image,
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
                        shipModel.ship_name.toString(),
                        style = TextStyle(fontSize = 15.sp, textAlign = TextAlign.Center),
                        color = Color.Black,
                    )
                    Text(
                        shipModel.ship_type.toString(),
                        style = TextStyle(fontSize = 15.sp, textAlign = TextAlign.Center),
                        color = Color.Black,
                    )
                }
            }
        }
    }
}
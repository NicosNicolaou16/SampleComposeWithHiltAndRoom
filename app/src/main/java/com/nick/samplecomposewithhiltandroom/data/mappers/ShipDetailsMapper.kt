package com.nick.samplecomposewithhiltandroom.data.mappers

import com.nick.samplecomposewithhiltandroom.compose.ships_screen.models.ShipDetailsUi
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsEntity

fun ShipsEntity.toShipDetailsUi(): ShipDetailsUi {
    return ShipDetailsUi(
        id = id,
        shipName = shipName,
        shipType = shipType,
        image = image
    )
}
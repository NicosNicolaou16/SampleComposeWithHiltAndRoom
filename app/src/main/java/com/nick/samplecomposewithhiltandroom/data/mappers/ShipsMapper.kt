package com.nick.samplecomposewithhiltandroom.data.mappers

import com.nick.samplecomposewithhiltandroom.compose.ships_screen.models.ShipsUi
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsEntity

fun ShipsEntity.toShipsUi(): ShipsUi {
    return ShipsUi(
        id = id,
        shipName = shipName,
        shipType = shipType,
        image = image,
    )
}
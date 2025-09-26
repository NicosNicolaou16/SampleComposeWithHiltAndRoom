package com.nick.samplecomposewithhiltandroom.domain.remote.ship_service

import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsEntity
import com.nick.samplecomposewithhiltandroom.domain.dto.ShipsDto
import retrofit2.http.GET

interface ShipService {

    @GET("v3/ships")
        suspend fun getShips(): MutableList<ShipsDto>
}
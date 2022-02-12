package com.nick.samplecomposewithhiltandroom.utils.ship_service

import com.nick.samplecomposewithhiltandroom.room_database.ships.ShipsModel
import retrofit2.http.GET

interface ShipService {

    @GET("v3/ships")
    suspend fun getShips(): MutableList<ShipsModel>
}
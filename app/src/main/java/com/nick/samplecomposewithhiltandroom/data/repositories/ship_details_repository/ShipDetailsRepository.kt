package com.nick.samplecomposewithhiltandroom.data.repositories.ship_details_repository

import com.nick.samplecomposewithhiltandroom.compose.ships_screen.models.ShipDetailsUi
import com.nick.samplecomposewithhiltandroom.data.mappers.toShipDetailsUi
import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.MyRoomDatabase
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsEntity
import javax.inject.Inject

class ShipDetailsRepository @Inject constructor(
    var myRoomDatabase: MyRoomDatabase
) {

    suspend fun queryShipById(id: String): ShipDetailsUi? {
        return myRoomDatabase.shipDao().getShipById(id)?.toShipDetailsUi()
    }
}
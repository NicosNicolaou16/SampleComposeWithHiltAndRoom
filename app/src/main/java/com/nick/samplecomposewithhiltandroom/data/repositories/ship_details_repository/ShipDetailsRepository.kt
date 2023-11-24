package com.nick.samplecomposewithhiltandroom.data.repositories.ship_details_repository

import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.MyRoomDatabase
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsModel
import javax.inject.Inject

class ShipDetailsRepository  @Inject constructor(
    var myRoomDatabase: MyRoomDatabase
) {

    suspend fun queryShipById(id: String): ShipsModel? {
        return myRoomDatabase.shipDao().getShipById(id)
    }
}
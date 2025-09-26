package com.nick.samplecomposewithhiltandroom.data.repositories.ship_details_repository

import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.MyRoomDatabase
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsEntity
import javax.inject.Inject

class ShipDetailsRepository @Inject constructor(
    var myRoomDatabase: MyRoomDatabase
) {

    suspend fun queryShipById(id: String): ShipsEntity? {
        return ShipsEntity.getShipById(id, myRoomDatabase)
    }
}
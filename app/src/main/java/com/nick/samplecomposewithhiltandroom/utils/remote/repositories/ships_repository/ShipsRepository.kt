package com.nick.samplecomposewithhiltandroom.utils.remote.repositories.ships_repository

import com.nick.samplecomposewithhiltandroom.room_database.init_database.MyRoomDatabase
import com.nick.samplecomposewithhiltandroom.room_database.ships.ShipsModel
import com.nick.samplecomposewithhiltandroom.utils.remote.ship_service.ShipService
import javax.inject.Inject

class ShipsRepository @Inject constructor(
    var shipService: ShipService,
    var myRoomDatabase: MyRoomDatabase
) {

    suspend fun fetchAndSaveShipsData(): MutableList<ShipsModel> {
        var shipsList = shipService.getShips()
        ShipsModel.insertTheShips(shipsList, myRoomDatabase).collect {
            shipsList = it
        }
        return shipsList
    }

}
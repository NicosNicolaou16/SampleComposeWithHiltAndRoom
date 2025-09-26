package com.nick.samplecomposewithhiltandroom.data.repositories.ships_repository

import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.MyRoomDatabase
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsEntity
import com.nick.samplecomposewithhiltandroom.domain.dto.ShipsDto
import com.nick.samplecomposewithhiltandroom.domain.dto.toPositionEntity
import com.nick.samplecomposewithhiltandroom.domain.dto.toShipsEntity
import com.nick.samplecomposewithhiltandroom.domain.remote.ship_service.ShipService
import javax.inject.Inject

class ShipsRepository @Inject constructor(
    private var shipService: ShipService,
    private var myRoomDatabase: MyRoomDatabase
) {

    suspend fun fetchShipsData(): MutableList<ShipsDto> {
        val shipsList: MutableList<ShipsDto> = shipService.getShips()
        saveShipDataIntoDatabase(shipsDtoList = shipsList)
        return shipsList
    }

    private suspend fun saveShipDataIntoDatabase(shipsDtoList: MutableList<ShipsDto>) {
        myRoomDatabase.shipDao()
            .insertOrReplaceList(data = shipsDtoList.map { it.toShipsEntity() }.toMutableList())
        myRoomDatabase.positionDao().insertOrReplaceList(data = shipsDtoList.map {
            it.positionDto.toPositionEntity(shipId = it.id)
        }.toMutableList())
    }

    suspend fun queryToGetAllShips(): MutableList<ShipsEntity> {
        return myRoomDatabase.shipDao().getAllShips()
    }
}
package com.nick.samplecomposewithhiltandroom.data.room_database.ships

import androidx.room.Dao
import androidx.room.Query
import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.BaseDao

@Dao
interface ShipsDao : BaseDao<ShipsModel, MutableList<ShipsModel>> {

    @Query("SELECT * FROM shipsmodel")
    suspend fun getAllShips(): MutableList<ShipsModel>

    @Query("SELECT * FROM shipsmodel WHERE ship_id=:id")
    suspend fun getShipById(id: String): ShipsModel?
}
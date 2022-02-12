package com.nick.samplecomposewithhiltandroom.room_database.ships

import androidx.room.Dao
import androidx.room.Query
import com.nick.samplecomposewithhiltandroom.room_database.init_database.BaseDao

@Dao
interface ShipsDao : BaseDao<ShipsModel, MutableList<ShipsModel>> {

    @Query("SELECT * FROM shipsmodel")
    suspend fun getAllShips(): MutableList<ShipsModel>
}
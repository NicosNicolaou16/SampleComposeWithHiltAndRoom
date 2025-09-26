package com.nick.samplecomposewithhiltandroom.data.room_database.ships.dao

import androidx.room.Dao
import androidx.room.Query
import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.BaseDao
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipAndPosition
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsEntity

@Dao
interface ShipsDao : BaseDao<ShipsEntity, MutableList<ShipsEntity>> {

    @Query("SELECT * FROM ShipsEntity")
    suspend fun getAllShips(): MutableList<ShipsEntity>

    @Query("SELECT * FROM ShipsEntity")
    suspend fun getShipAndPosition(): MutableList<ShipAndPosition>

    @Query("SELECT * FROM shipsentity WHERE id=:id")
    suspend fun getShipById(id: String): ShipsEntity?
}
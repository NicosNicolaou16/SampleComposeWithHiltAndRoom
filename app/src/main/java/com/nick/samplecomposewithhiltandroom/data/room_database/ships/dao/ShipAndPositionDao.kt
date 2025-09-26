package com.nick.samplecomposewithhiltandroom.data.room_database.ships.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipAndPosition

/**
 * One to One relationship Dao
 * */
@Dao
interface ShipAndPositionDao {

    @Transaction
    @Query("SELECT * FROM PositionEntity")
    fun getShipAndPosition(): MutableList<ShipAndPosition>
}
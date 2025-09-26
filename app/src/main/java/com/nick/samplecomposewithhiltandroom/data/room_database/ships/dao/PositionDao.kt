package com.nick.samplecomposewithhiltandroom.data.room_database.ships.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.BaseDao
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.PositionEntity

@Dao
interface PositionDao: BaseDao<PositionEntity, MutableList<PositionEntity>> {

    @Transaction
    @Query("SELECT * FROM positionentity WHERE id = :id")
    suspend fun getPositionById(id: Long): PositionEntity?

    @Transaction
    @Query("DELETE FROM PositionEntity")
    suspend fun deleteAll()
}
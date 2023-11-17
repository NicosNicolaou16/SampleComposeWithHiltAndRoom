package com.nick.samplecomposewithhiltandroom.data.room_database.ships

import androidx.room.Dao
import androidx.room.Query
import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.BaseDao

@Dao
interface PositionDao: BaseDao<PositionModel, MutableList<PositionModel>> {

    @Query("SELECT * FROM positionmodel")
    suspend fun getPosition(): PositionModel

    @Query("DELETE FROM PositionModel")
    suspend fun deleteAll()
}
package com.nick.samplecomposewithhiltandroom.data.room_database.init_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.PositionDao
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.PositionModel
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsDao
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsModel
import com.nick.samplecomposewithhiltandroom.data.room_database.type_converter.ConverterPosition
import javax.inject.Inject

@Database(
    entities = [ShipsModel::class, PositionModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    ConverterPosition::class,
)
abstract class MyRoomDatabase : RoomDatabase() {
    abstract fun shipDao(): ShipsDao
    abstract fun positionDao(): PositionDao

    @Inject
    protected lateinit var myRoomDatabase: MyRoomDatabase

    companion object {
        internal const val DB_NAME = "DB_NAME"
    }

    fun deleteAll() {
        myRoomDatabase.clearAllTables()
    }
}
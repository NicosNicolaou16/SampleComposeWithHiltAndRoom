package com.nick.samplecomposewithhiltandroom.room_database.init_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nick.samplecomposewithhiltandroom.room_database.type_converter.ConverterPosition
import com.nick.samplecomposewithhiltandroom.room_database.ships.*
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
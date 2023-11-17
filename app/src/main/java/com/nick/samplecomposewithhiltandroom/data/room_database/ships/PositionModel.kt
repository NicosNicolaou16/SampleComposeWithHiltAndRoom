package com.nick.samplecomposewithhiltandroom.data.room_database.ships

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.MyRoomDatabase
import kotlinx.coroutines.flow.flow

@Entity
data class PositionModel(
        @PrimaryKey(autoGenerate = true)
        var position_id: Long,
        var latitude: Double?,
        var longitude: Double?
) {

    constructor() : this(-1, null, null)

    companion object {
        suspend fun insertThePosition(positionModel: PositionModel, myRoomDatabase: MyRoomDatabase) =
            flow {
                myRoomDatabase.positionDao().insertOrReplaceObject(positionModel)
                emit(myRoomDatabase.positionDao().getPosition())
            }
        }
}
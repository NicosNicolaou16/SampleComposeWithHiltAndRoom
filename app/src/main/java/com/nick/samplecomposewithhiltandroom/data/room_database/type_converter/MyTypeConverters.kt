package com.nick.samplecomposewithhiltandroom.data.room_database.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.PositionEntity

class ConverterPosition {

    @TypeConverter
    fun fromStringToPositions(value: String): PositionEntity? {
        return Gson().fromJson(value, object : TypeToken<PositionEntity>() {}.type)
    }

    @TypeConverter
    fun fromPositionToString(positionEntity: PositionEntity): String = Gson().toJson(positionEntity)
}



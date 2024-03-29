package com.nick.samplecomposewithhiltandroom.data.room_database.type_converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.PositionModel

class ConverterPosition {

    @TypeConverter
    fun fromStringToPositions(value: String): PositionModel? {
        return Gson().fromJson(value, object : TypeToken<PositionModel>() {}.type)
    }

    @TypeConverter
    fun fromPositionToString(positionModel: PositionModel): String = Gson().toJson(positionModel)
}



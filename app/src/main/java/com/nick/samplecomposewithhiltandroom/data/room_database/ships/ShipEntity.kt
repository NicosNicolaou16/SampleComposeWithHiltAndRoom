package com.nick.samplecomposewithhiltandroom.data.room_database.ships

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.MyRoomDatabase
import com.nick.samplecomposewithhiltandroom.data.room_database.type_converter.ConverterPosition
import kotlinx.coroutines.flow.flow

@Entity(indices = [Index(value = ["id"], unique = true)])
data class ShipsEntity(
    @PrimaryKey
    val id: String,
    val shipName: String?,
    val shipType: String?,
    val active: Boolean?,
    val imo: Long?,
    val mmsi: Long?,
    val abs: Long?,
    val clazz: Long?,
    val weightLbs: Long?,
    val yearBuilt: Long?,
    val homePort: String?,
    val status: String?,
    val speedKn: Int?,
    val courseDeg: String?,
    val successfulLandings: Int?,
    val attemptedLandings: Int?,
    val url: String?,
    val image: String?,
) {
    //empty constructor for room
    constructor() : this(
        id = "",
        shipName = "",
        shipType = "",
        active = false,
        imo = 0,
        mmsi = 0,
        abs = 0,
        clazz = 0,
        weightLbs = 0,
        yearBuilt = 0,
        homePort = "",
        status = "",
        speedKn = 0,
        courseDeg = "",
        successfulLandings = 0,
        attemptedLandings = 0,
        url = "",
        image = "",
    )
}
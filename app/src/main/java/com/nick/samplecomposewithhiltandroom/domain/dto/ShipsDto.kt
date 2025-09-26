package com.nick.samplecomposewithhiltandroom.domain.dto

import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsEntity
import com.nick.samplecomposewithhiltandroom.data.room_database.type_converter.ConverterPosition

data class ShipsDto(
    @SerializedName("ship_id")
    val id: String,
    @SerializedName("ship_name")
    val shipName: String?,
    @SerializedName("ship_type")
    val shipType: String?,
    val active: Boolean?,
    val imo: Long?,
    val mmsi: Long?,
    val abs: Long?,
    @SerializedName("class")
    val clazz: Long?,
    @SerializedName("mass_kg")
    val weightLbs: Long?,
    @SerializedName("year_built")
    val yearBuilt: Long?,
    @SerializedName("home_port")
    val homePort: String?,
    val status: String?,
    @SerializedName("speed_kn")
    val speedKn: Int?,
    @SerializedName("course_deg")
    val courseDeg: String?,
    @SerializedName("position")
    @TypeConverters(ConverterPosition::class)
    val positionDto: PositionDto,
    @SerializedName("successful_landings")
    val successfulLandings: Int?,
    @SerializedName("attempted_landings")
    val attemptedLandings: Int?,
    val url: String?,
    val image: String?,
)

fun ShipsDto.toShipsEntity(): ShipsEntity {
    return ShipsEntity(
        id = id,
        shipName = shipName,
        shipType = shipType,
        active = active,
        imo = imo,
        mmsi = mmsi,
        abs = abs,
        clazz = clazz,
        weightLbs = weightLbs,
        yearBuilt = yearBuilt,
        homePort = homePort,
        status = status,
        speedKn = speedKn,
        courseDeg = courseDeg,
        successfulLandings = successfulLandings,
        attemptedLandings = attemptedLandings,
        url = url,
        image = image
    )
}

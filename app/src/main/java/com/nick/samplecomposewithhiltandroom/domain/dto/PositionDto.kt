package com.nick.samplecomposewithhiltandroom.domain.dto

import com.nick.samplecomposewithhiltandroom.data.room_database.ships.PositionEntity

data class PositionDto(
    val latitude: Double?,
    val longitude: Double?,
    val shipId: String?
)

fun PositionDto.toPositionEntity(shipId: String): PositionEntity {
    return PositionEntity(
        latitude = latitude,
        longitude = longitude,
        shipId = shipId
    )
}

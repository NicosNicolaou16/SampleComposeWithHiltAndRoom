package com.nick.samplecomposewithhiltandroom.data.room_database.ships

import androidx.room.Embedded
import androidx.room.Relation

/**
 * One to One relationship
 * parentColumn = "id" ---->>>>>> is in the ship model and is the position model id to connect the position model with ship model
 * entityColumn = "shipId" ---->>>>>> is id of position model
 * */
data class ShipAndPosition(
    @Embedded
    val shipsEntity: ShipsEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "shipId",
    )
    val positionEntity: PositionEntity,
)
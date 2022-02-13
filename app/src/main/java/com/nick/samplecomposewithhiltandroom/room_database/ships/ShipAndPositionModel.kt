package com.nick.samplecomposewithhiltandroom.room_database.ships

import androidx.room.Embedded
import androidx.room.Relation

/**
 * One to One relationship
 * */
data class ShipAndPositionModel(
    @Embedded
        var positionModel: PositionModel,
    @Relation(
                parentColumn = "position_id",
                entityColumn = "positionId"
        )
        var shipsModel: ShipsModel
) {
}
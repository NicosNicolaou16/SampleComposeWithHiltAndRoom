package com.nick.samplecomposewithhiltandroom.data.room_database.ships

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.MyRoomDatabase
import kotlinx.coroutines.flow.flow

@Entity(
    indices = [Index(value = ["id"], unique = true), Index(value = ["shipId"], unique = true)],
    foreignKeys = [
        ForeignKey(
            entity = ShipsEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("shipId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PositionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val latitude: Double?,
    val longitude: Double?,
    val shipId: String?,
)
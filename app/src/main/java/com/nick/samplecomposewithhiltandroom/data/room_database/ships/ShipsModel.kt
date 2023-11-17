package com.nick.samplecomposewithhiltandroom.data.room_database.ships

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.nick.samplecomposewithhiltandroom.data.room_database.init_database.MyRoomDatabase
import com.nick.samplecomposewithhiltandroom.data.room_database.type_converter.ConverterPosition
import kotlinx.coroutines.flow.flow

@Entity(indices = [Index(value = ["ship_id"], unique = true)])
data class ShipsModel(
    @PrimaryKey
    var ship_id: String,
    var ship_name: String?,
    var ship_type: String?,
    var active: Boolean?,
    var imo: Long?,
    var mmsi: Long?,
    var abs: Long?,
    @SerializedName("class")
    var clazz: Long?,
    var weight_lbs: Long?,
    var year_built: Long?,
    var home_port: String?,
    var status: String?,
    var speed_kn: Int?,
    var course_deg: String?,
    @TypeConverters(ConverterPosition::class)
    var position: PositionModel,
    var positionId: Long,
    var successful_landings: Int?,
    var attempted_landings: Int?,
    var url: String?,
    var image: String?,
) {

    constructor() : this("",  null,null,  null,  null,null,  null,null,  null,null,  null,null,  null,null,  PositionModel(),-1,  null,null, null, null)

    companion object {
        suspend fun insertTheShips(
            shipsModelList: MutableList<ShipsModel>,
            myRoomDatabase: MyRoomDatabase
        ) =
            flow {
                saveShips(shipsModelList, myRoomDatabase).collect {
                    myRoomDatabase.shipDao()
                        .insertOrReplaceList(it) //insert the ship mode with position id
                }
                emit(
                    myRoomDatabase.shipDao().getAllShips()
                ) //return with flow - emit all ships data
            }

        private suspend fun saveShips(
            shipsModelList: MutableList<ShipsModel>,
            myRoomDatabase: MyRoomDatabase
        ) =
            flow {
                val shipsModelListSaved = mutableListOf<ShipsModel>()
                //delete the position and mission objects because their ids are auto generate (autoGenerate = true)
                myRoomDatabase.positionDao().deleteAll()
                shipsModelList.forEach { ship ->
                    savePosition(ship, myRoomDatabase)
                    shipsModelListSaved.add(ship) //add the ship data into list to insert into the database
                }
                emit(shipsModelListSaved)
            }

        /**
         * inset position object - one to one
         * */
        private suspend fun savePosition(ship: ShipsModel, myRoomDatabase: MyRoomDatabase) {
            PositionModel.insertThePosition(ship.position, myRoomDatabase).collect {
                ship.positionId =
                    it.position_id //get the position_id from PositionModel and assign to positionId (ShipModel)
            }
        }
    }
}
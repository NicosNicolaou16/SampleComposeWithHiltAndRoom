package com.nick.samplecomposewithhiltandroom.ui.ships_screen

import android.app.Application
import com.nick.samplecomposewithhiltandroom.utils.ship_service.ShipService
import com.nick.samplecomposewithhiltandroom.utils.base_classes.BaseViewModel
import com.nick.samplecomposewithhiltandroom.room_database.ships.ShipsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipsViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    var shipsModelStateFlow = MutableStateFlow<MutableList<ShipsModel>>(mutableListOf())

    init {
        requestForShipsData()
    }

    @Inject protected lateinit var shipService: ShipService

    private fun requestForShipsData() = launch {
        loading.value = true
        flow {
            val shipsList =
                shipService.getShips() //get the data from server
            var shipModel = mutableListOf<ShipsModel>()
            //save the data to local database and return to the view
            ShipsModel.insertTheShips(shipsList, myRoomDatabase).collect {
                shipModel = it
            }
            emit(shipModel)
        }.flowOn(Dispatchers.IO)
            .catch { e ->
                loading.value = false
                error.value = handleErrorMessage(e)
            }.collect {
                loading.value = false
                shipsModelStateFlow.value = it
            }
    }
}
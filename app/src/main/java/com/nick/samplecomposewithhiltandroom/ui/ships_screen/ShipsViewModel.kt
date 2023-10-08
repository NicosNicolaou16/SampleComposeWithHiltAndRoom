package com.nick.samplecomposewithhiltandroom.ui.ships_screen

import android.app.Application
import com.nick.samplecomposewithhiltandroom.room_database.ships.ShipsModel
import com.nick.samplecomposewithhiltandroom.utils.base_classes.BaseViewModel
import com.nick.samplecomposewithhiltandroom.utils.remote.repositories.ships_repository.ShipsRepository
import com.nick.samplecomposewithhiltandroom.utils.remote.ship_service.ShipService
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
        offline()
    }

    @Inject
    protected lateinit var shipsRepository: ShipsRepository

    private fun requestForShipsData() = launch {
        loading.value = true
        flow {
            val shipsList =
                shipsRepository.fetchAndSaveShipsData() //get the data from the server
            emit(shipsList)
        }.flowOn(Dispatchers.IO)
            .catch { e ->
                loading.value = false
                error.value = handleErrorMessage(e)
            }.collect {
                loading.value = false
                shipsModelStateFlow.value = it
            }
    }

    private fun offline() = launch {
        loading.value = true
        flow {
            val shipsList =
                shipsRepository.queryToGetAllShips() //get the data from the local database
            emit(shipsList)
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
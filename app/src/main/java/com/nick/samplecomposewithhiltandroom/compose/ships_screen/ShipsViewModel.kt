package com.nick.samplecomposewithhiltandroom.compose.ships_screen

import android.app.Application
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsEntity
import com.nick.samplecomposewithhiltandroom.utils.base_classes.BaseViewModel
import com.nick.samplecomposewithhiltandroom.data.repositories.ships_repository.ShipsRepository
import com.nick.samplecomposewithhiltandroom.domain.dto.ShipsDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipsViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    private val _shipsEntityStateFlow = MutableStateFlow<MutableList<ShipsDto>>(mutableListOf())
    val shipsEntityStateFlow: StateFlow<MutableList<ShipsDto>> = _shipsEntityStateFlow

    init {
        requestForShipsData()
        offline()
    }

    @Inject
    internal lateinit var shipsRepository: ShipsRepository

    private fun requestForShipsData() = launch {
        loading.value = true
        flow {
            val shipsList =
                shipsRepository.fetchShipsData() //get the data from the server
            emit(shipsList)
        }.flowOn(Dispatchers.IO)
            .catch { e ->
                loading.value = false
                error.value = handleErrorMessage(e)
            }.collect {
                loading.value = false
                _shipsEntityStateFlow.value = it
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
                _shipsEntityStateFlow.value = it
            }
    }
}
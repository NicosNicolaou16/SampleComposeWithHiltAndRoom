package com.nick.samplecomposewithhiltandroom.compose.ship_details_screen

import android.app.Application
import com.nick.samplecomposewithhiltandroom.data.room_database.ships.ShipsModel
import com.nick.samplecomposewithhiltandroom.utils.base_classes.BaseViewModel
import com.nick.samplecomposewithhiltandroom.data.repositories.ship_details_repository.ShipDetailsRepository
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
class ShipDetailsViewModel @Inject constructor(application: Application) :
    BaseViewModel(application) {

    private val _shipDetails = MutableStateFlow<ShipsModel>(ShipsModel())
    val shipDetails: StateFlow<ShipsModel> = _shipDetails

    @Inject
    internal lateinit var shipDetailsRepository: ShipDetailsRepository

    fun queryShipById(id: String) = launch {
        flow {
            val shipsModel: ShipsModel? = shipDetailsRepository.queryShipById(id)
            emit(shipsModel)
        }.flowOn(Dispatchers.Default)
            .catch { e ->
                error.value = handleErrorMessage(e)
            }.collect {
                if (it != null) {
                    _shipDetails.value = it
                }
            }
    }
}
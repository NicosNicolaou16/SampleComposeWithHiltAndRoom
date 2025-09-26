package com.nick.samplecomposewithhiltandroom.compose.ship_details_screen

import android.app.Application
import com.nick.samplecomposewithhiltandroom.compose.ships_screen.models.ShipDetailsUi
import com.nick.samplecomposewithhiltandroom.utils.base_classes.BaseViewModel
import com.nick.samplecomposewithhiltandroom.data.repositories.ship_details_repository.ShipDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipDetailsViewModel @Inject constructor(application: Application) :
    BaseViewModel(application) {

    private val _shipDetails = MutableStateFlow<ShipDetailsUi>(
        ShipDetailsUi(
            id = "",
            shipName = "",
            shipType = "",
            image = ""
        )
    )
    val shipDetails: StateFlow<ShipDetailsUi> = _shipDetails

    @Inject
    internal lateinit var shipDetailsRepository: ShipDetailsRepository

    fun queryShipById(id: String) = launch {
        flow {
            val shipsEntity: ShipDetailsUi? = shipDetailsRepository.queryShipById(id)
            emit(shipsEntity)
        }.flowOn(Dispatchers.Default)
            .catch { e ->
                error.value = handleErrorMessage(e)
            }.filterNotNull()
            .collect {
                _shipDetails.value = it
            }
    }
}
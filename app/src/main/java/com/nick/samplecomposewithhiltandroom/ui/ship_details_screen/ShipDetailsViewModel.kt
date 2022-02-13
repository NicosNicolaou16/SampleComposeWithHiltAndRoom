package com.nick.samplecomposewithhiltandroom.ui.ship_details_screen

import android.app.Application
import com.nick.samplecomposewithhiltandroom.room_database.ships.ShipsModel
import com.nick.samplecomposewithhiltandroom.utils.base_classes.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipDetailsViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    val shipDetails = MutableStateFlow<ShipsModel>(ShipsModel())

    fun queryShipById(id: String) = launch {
        flow {
            val shipsModel: ShipsModel? = myRoomDatabase.shipDao().getShipById(id)
            emit(shipsModel)
        }.flowOn(Dispatchers.Default)
            .catch { e ->
                error.value = handleErrorMessage(e)
            }.collect {
                if (it != null) {
                    shipDetails.value = it
                }
            }
    }
}
package com.example.composeandgmaps.detailView.viewmodel

import android.util.Log
import com.example.composeandgmaps.base.BaseViewModel
import com.example.composeandgmaps.detailView.model.MarkerData
import com.example.composeandgmaps.rest.model.ResultApiItem
import com.example.composeandgmaps.util.TAG
import com.example.composeandgmaps.util.safeLet
import com.google.android.libraries.maps.model.MarkerOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel : BaseViewModel() {

    private val _state = MutableStateFlow<UIState>(UIState.Loading)
    val state: StateFlow<UIState>
        get() = _state.asStateFlow()

    /**
     * Function that will generate a lis of [MarkerOptions] that will be used to setup the markers
     * */
    fun generateListOfMarkers(data: List<ResultApiItem>) {
        if (_state.value == UIState.Loading) {
            if (data.isNotEmpty()) {
                val listOfMarkerData = mutableListOf<MarkerData>()
                data.forEach { item ->
                    safeLet(
                        item.applicant,
                        item.latitude,
                        item.longitude,
                        item.locationid
                    ) { applicant, latitude, longitude, locationid ->

                        listOfMarkerData.add(
                            MarkerData(
                                applicant = applicant,
                                locationid = locationid,
                                location = item.location,
                                latitude = latitude.toDouble(),
                                longitude = longitude.toDouble(),
                                locationDesc = item.locationdesc,
                                optionalText = item.optionaltext
                            )
                        )
                    }
                }
                _state.value = UIState.Success(data = listOfMarkerData)
            } else {
                Log.e(this.TAG(), "generateListOfMarkers::No markers available")
                _state.value = UIState.Error("No markers available")
            }
        }
    }

    /**
     * Sealed class for representing all the available states in the Google Maps
     * */
    sealed class UIState {
        object Loading : UIState()
        class Success(val data: List<MarkerData>) : UIState()
        class Error(val message: String) : UIState()
    }

}
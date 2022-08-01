package com.example.redfincodechallenge.detailView.viewmodel

import android.util.Log
import com.example.redfincodechallenge.base.BaseViewModel
import com.example.redfincodechallenge.rest.model.ResultApiItem
import com.example.redfincodechallenge.util.TAG
import com.example.redfincodechallenge.util.safeLet
import com.google.android.libraries.maps.model.LatLng
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
                val listOfMarkerOptions = mutableListOf<MarkerOptions>()
                data.forEach { item ->
                    safeLet(
                        item.applicant,
                        item.latitude,
                        item.longitude
                    ) { location, latitude, longitude ->

                        val latLong = LatLng(latitude.toDouble(), longitude.toDouble())
                        val markerOption = MarkerOptions()
                            .title(location)
                            .position(latLong)

                        listOfMarkerOptions.add(markerOption)
                    }
                }
                _state.value = UIState.Success(markers = listOfMarkerOptions)
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
        class Success(val markers: List<MarkerOptions>) : UIState()
        class Error(val message: String) : UIState()
    }

}
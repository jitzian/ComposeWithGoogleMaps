package com.example.redfincodechallenge.mainView.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.example.redfincodechallenge.base.BaseViewModel
import com.example.redfincodechallenge.constants.GlobalConstants
import com.example.redfincodechallenge.rest.model.ResultApiItem
import com.example.redfincodechallenge.util.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : BaseViewModel() {

    private val _state = MutableStateFlow<UIState>(UIState.Loading)
    val state: StateFlow<UIState>
        get() = _state.asStateFlow()

    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchData() = viewModelScope.launch {
        try {
            withTimeout(GlobalConstants.MAX_TIME_OUT) {
                withContext(Dispatchers.IO) {
                    if (_state.value == UIState.Loading) {
                        val result = restApi.getData()
                        Log.e(this.TAG(), "fetchData::result::${result.size}")
                        if (result.isEmpty()) {
                            _state.value = UIState.Error(message = "No data is available")
                        } else {

                            val filteredData = result.filter { data ->
                                safeLet(
                                    data.dayofweekstr,
                                    data.starttime,
                                    data.endtime
                                ) { dayOfWeekStr, startTime, endTime ->
                                    dayOfWeekStr == getWeekDay().value && checkAMHours(startTime) && checkPMHours(
                                        endTime
                                    )
                                }!!
                            }.map {
                                it
                            }
                            Log.e(this.TAG(), "fetchData::filteredData::${filteredData.size}")

                            _state.value = UIState.Success(data = filteredData)
                        }
                    }
                }
            }
        } catch (tce: TimeoutCancellationException) {
            Log.e(this.TAG(), "fetchData::${tce.message}")
            _state.value = UIState.Error(message = tce.message ?: "An error occurred")
        } catch (e: Exception) {
            Log.e(this.TAG(), "fetchData::${e.message}")
            _state.value = UIState.Error(message = e.message ?: "General Error: An error occurred")
        }
    }

    /**
     * Sealed class with all the available states that will populate the UI
     * */
    sealed class UIState {
        object Loading : UIState()
        class Success(val data: List<ResultApiItem>) : UIState()
        class Error(val message: String) : UIState()
    }
}
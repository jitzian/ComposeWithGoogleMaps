package com.example.redfincodechallenge.mainView.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.redfincodechallenge.base.BaseViewModel
import com.example.redfincodechallenge.constants.GlobalConstants
import com.example.redfincodechallenge.rest.model.ResultApi
import com.example.redfincodechallenge.util.TAG
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : BaseViewModel() {

    private val _state = MutableStateFlow<UIState>(UIState.Loading)
    val state: StateFlow<UIState>
        get() = _state.asStateFlow()

    fun fetchData() = viewModelScope.launch {
        try {
            withTimeout(GlobalConstants.MAX_TIME_OUT) {
                withContext(Dispatchers.IO) {
                    if (_state.value == UIState.Loading) {
                        val result = restApi.getData()
                        Log.e(this.TAG(), "fetchData::result::$result")
                        if (result.isEmpty()) {
                            _state.value = UIState.Error(message = "No data is available")
                        } else {
                            _state.value = UIState.Success(data = result)
                        }
                    }
                }
            }
        } catch (toce: TimeoutCancellationException) {
            Log.e(this.TAG(), "fetchData::${toce.message}")
            _state.value = UIState.Error(message = toce.message ?: "An error occurred")
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
        class Success(val data: ResultApi) : UIState()
        class Error(val message: String) : UIState()
    }
}
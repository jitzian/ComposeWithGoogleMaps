package com.example.redfincodechallenge.mainView.view

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.redfincodechallenge.mainView.viewmodel.MainViewModel
import com.example.redfincodechallenge.rest.model.ResultApiItem
import com.example.redfincodechallenge.ui.app.RedFinScreen
import com.example.redfincodechallenge.ui.common.ErrorScreen
import com.example.redfincodechallenge.ui.common.LoadingScreen
import com.example.redfincodechallenge.util.TAG

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreenState(mainViewModel: MainViewModel = viewModel()) {
    val state by mainViewModel.state.collectAsState()
    mainViewModel.fetchData()

    when (state) {
        is MainViewModel.UIState.Loading -> {
            LoadingScreen()
        }
        is MainViewModel.UIState.Success -> {
            MainScreen(data = (state as MainViewModel.UIState.Success).data)
        }
        is MainViewModel.UIState.Error -> {
            ErrorScreen(message = (state as MainViewModel.UIState.Error).message)
        }
    }
}

@Composable
fun MainScreen(data: List<ResultApiItem>) {
    val state = rememberLazyListState()
    RedFinScreen {
        Scaffold {
            LazyColumn(state = state) {
                items(data) { item ->
                    ItemRow(data = item, onItemSelected = {
                        Log.e(this.TAG(), "MainScreen::CLICKED")
                    })
                }
            }
        }
    }
}


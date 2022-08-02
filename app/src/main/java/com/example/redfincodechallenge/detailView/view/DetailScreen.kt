package com.example.redfincodechallenge.detailView.view

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.redfincodechallenge.detailView.viewmodel.DetailViewModel
import com.example.redfincodechallenge.mainView.model.Items
import com.example.redfincodechallenge.ui.app.RedFinScreen
import com.example.redfincodechallenge.ui.common.ErrorScreen
import com.example.redfincodechallenge.ui.common.LoadingScreen
import com.google.android.libraries.maps.model.MarkerOptions
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun DetailScreenState(items: Items, detailViewModel: DetailViewModel = viewModel()) {

    val state by detailViewModel.state.collectAsState()
    detailViewModel.generateListOfMarkers(items.data)

    when (state) {
        is DetailViewModel.UIState.Loading -> {
            LoadingScreen()
        }
        is DetailViewModel.UIState.Success -> {
            DetailScreen(
                data = (state as DetailViewModel.UIState.Success).markers
            )
        }
        is DetailViewModel.UIState.Error -> {
            ErrorScreen(message = (state as DetailViewModel.UIState.Error).message)
        }
    }
}

@Composable
fun DetailScreen(data: List<MarkerOptions>) {
    RedFinScreen {
        Scaffold {
            GoogleMaps(data)
        }
    }
}

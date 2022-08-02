package com.example.redfincodechallenge.detailView.view

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.redfincodechallenge.R
import com.example.redfincodechallenge.destinations.MainScreenStateDestination
import com.example.redfincodechallenge.detailView.viewmodel.DetailViewModel
import com.example.redfincodechallenge.mainView.model.Items
import com.example.redfincodechallenge.rest.model.ResultApiItem
import com.example.redfincodechallenge.ui.app.RedFinScreen
import com.example.redfincodechallenge.ui.common.ErrorScreen
import com.example.redfincodechallenge.ui.common.LoadingScreen
import com.example.redfincodechallenge.ui.common.MainTopBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DetailScreenState(
    selectedItem: ResultApiItem,
    items: Items,
    detailViewModel: DetailViewModel = viewModel(),
    navigator: DestinationsNavigator
) {

    val state by detailViewModel.state.collectAsState()
    detailViewModel.generateListOfMarkers(items.data)

    when (state) {
        is DetailViewModel.UIState.Loading -> {
            LoadingScreen()
        }
        is DetailViewModel.UIState.Success -> {
            DetailScreen(
                data = (state as DetailViewModel.UIState.Success).data,
                selectedItem = selectedItem
            ) {
                with(navigator) {
                    navigate(
                        MainScreenStateDestination()
                    )
                    popBackStack()
                }
            }
        }
        is DetailViewModel.UIState.Error -> {
            ErrorScreen(message = (state as DetailViewModel.UIState.Error).message)
        }
    }
}

@Composable
fun DetailScreen(
    data: List<DetailViewModel.MarkerData>,
    selectedItem: ResultApiItem,
    onUpClick: () -> Unit
) {
    RedFinScreen {
        Scaffold(
            topBar = {
                MainTopBar(
                    title = stringResource(id = R.string.open_business_TEXT),
                    showBackButton = true,
                    onUpClick = onUpClick
                )
            }
        ) {
            GoogleMaps(data, selectedItem)
        }
    }
}

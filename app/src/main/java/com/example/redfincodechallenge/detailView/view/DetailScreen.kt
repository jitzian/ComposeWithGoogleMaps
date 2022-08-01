package com.example.redfincodechallenge.detailView.view

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.redfincodechallenge.mainView.model.Items
import com.example.redfincodechallenge.mainView.view.MainScreenState
import com.example.redfincodechallenge.mainView.viewmodel.MainViewModel
import com.example.redfincodechallenge.rest.model.ResultApiItem
import com.example.redfincodechallenge.ui.app.RedFinScreen
import com.example.redfincodechallenge.ui.common.ErrorScreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DetailScreenState(items: Items) {
    Log.e("DetailScreenState", "DetailScreenState: --> $items")
    DetailScreen(data = items.data)
}

@Composable
fun DetailScreen(data: List<ResultApiItem>) {
    Log.e("DetailScreen", "DetailScreen")
    RedFinScreen {
        Scaffold {
            Text(text = "Details")
        }
    }
}
package com.example.redfincodechallenge.detailView.view

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.redfincodechallenge.ui.app.RedFinScreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun DetailScreenState() {
    DetailScreen()
}

@Composable
@Preview(showBackground = true)
fun DetailScreen() {
    RedFinScreen {
        Scaffold {
            Text(text = "Details")
        }
    }
}
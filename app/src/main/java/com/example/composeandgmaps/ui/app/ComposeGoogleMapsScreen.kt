package com.example.composeandgmaps.ui.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composeandgmaps.ui.theme.ComposeGoogleMapsTheme

@Composable
fun ComposeGoogleMapsScreen(content: @Composable () -> Unit) {
    ComposeGoogleMapsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}
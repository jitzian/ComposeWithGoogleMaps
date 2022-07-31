package com.example.redfincodechallenge.ui.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.redfincodechallenge.ui.theme.RedfinCodeChallengeTheme

@Composable
fun RedFinApp() {

}

@Composable
fun RedFinScreen(content: @Composable () -> Unit) {
    RedfinCodeChallengeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}
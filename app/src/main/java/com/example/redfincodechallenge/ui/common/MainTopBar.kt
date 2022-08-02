package com.example.redfincodechallenge.ui.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun MainTopBar(
    title: String,
    showBackButton: Boolean = false,
    onUpClick: (() -> Unit)? = null
) {
    if (showBackButton) {
        TopAppBar(
            title = {
                Text(text = title)
            },
            navigationIcon = {
                onUpClick?.let { ArrowBackIcon(it) }
            }
        )
    } else {
        TopAppBar {
            Text(text = title)
        }
    }
}
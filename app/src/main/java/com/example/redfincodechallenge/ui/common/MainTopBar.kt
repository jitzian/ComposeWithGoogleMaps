package com.example.redfincodechallenge.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.redfincodechallenge.R

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
            Text(
                text = title,
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.dimen_8_dp))
            )
        }
    }
}
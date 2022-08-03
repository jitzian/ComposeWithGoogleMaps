package com.example.composeandgmaps.ui.common

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.composeandgmaps.R

@Composable
fun ArrowBackIcon(onUpClick: () -> Unit) {
    IconButton(
        onClick = onUpClick
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(id = R.string.back_TEXT)
        )
    }
}
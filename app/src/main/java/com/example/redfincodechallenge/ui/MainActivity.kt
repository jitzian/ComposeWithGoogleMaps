package com.example.redfincodechallenge.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.redfincodechallenge.NavGraph
import com.example.redfincodechallenge.NavGraphs
import com.example.redfincodechallenge.mainView.view.MainScreenState
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MainScreenState()
            DestinationsNavHost(navGraph = NavGraphs.root)
        }
    }
}

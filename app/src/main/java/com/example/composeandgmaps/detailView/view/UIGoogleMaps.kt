package com.example.composeandgmaps.detailView.view

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.composeandgmaps.detailView.viewmodel.DetailViewModel
import com.example.composeandgmaps.rest.model.ResultApiItem
import com.example.composeandgmaps.util.safeLet
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.MapView
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions
import com.google.maps.android.ktx.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Note: Took these links as reference to implement Maps
 * https://www.rrtutors.com/tutorials/How-do-i-load-GoogleMaps-with-Jetpack-Compose
 * https://rrtutors.com/tutorials/Jetpack-Compose-How-to-Add-Multiple-Markers-to-Google-Maps
 * */

@Composable
fun GoogleMaps(data: List<DetailViewModel.MarkerData>, selectedItem: ResultApiItem) {
    val mapView = rememberMapViewWithLifeCycle()

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            AndroidView({ mapView }) { mapView ->
                CoroutineScope(Dispatchers.Main).launch {

                    mapView.getMapAsync { map ->
                        map.mapType = 1
                        map.uiSettings.isZoomControlsEnabled = true

                        data.forEach { item ->
                            safeLet(item.latitude, item.longitude) { latitude, longitude ->
                                val markerOption = MarkerOptions()
                                    .title(item.applicant)
                                    .position(LatLng(latitude, longitude))
                                map.addMarker(markerOption)
                            }
                        }

                        val markerToBeInCamera = data.filter { item ->
                            item.locationid == selectedItem.locationid
                        }.map { it }

                        if (markerToBeInCamera.size == 1) {
                            safeLet(
                                markerToBeInCamera.first().latitude,
                                markerToBeInCamera.first().longitude
                            ) { safeLatitude, safeLongitude ->
                                map.moveCamera(
                                    CameraUpdateFactory.newLatLngZoom(
                                        LatLng(
                                            safeLatitude,
                                            safeLongitude
                                        ), 18f
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun rememberMapViewWithLifeCycle(): MapView {
    val context = LocalContext.current
    val mapView = remember {
        MapView(context).apply {
            id = R.id.map_frame
        }
    }
    val lifeCycleObserver = rememberMapLifecycleObserver(mapView)
    val lifeCycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifeCycle) {
        lifeCycle.addObserver(lifeCycleObserver)
        onDispose {
            lifeCycle.removeObserver(lifeCycleObserver)
        }
    }

    return mapView
}

@Composable
fun rememberMapLifecycleObserver(mapView: MapView): LifecycleEventObserver =
    remember(mapView) {
        LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
                Lifecycle.Event.ON_START -> mapView.onStart()
                Lifecycle.Event.ON_RESUME -> mapView.onResume()
                Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                Lifecycle.Event.ON_STOP -> mapView.onStop()
                Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
                else -> throw IllegalStateException()
            }
        }
    }
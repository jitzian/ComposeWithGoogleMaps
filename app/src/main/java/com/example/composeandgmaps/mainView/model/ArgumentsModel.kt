package com.example.composeandgmaps.mainView.model

import android.os.Parcelable
import com.example.composeandgmaps.rest.model.ResultApiItem
import kotlinx.parcelize.Parcelize

/**
 * This class holds the data that will be passed through the navArgs using parcelable interface
 * */
@Parcelize
data class Items(val data: List<ResultApiItem>) : Parcelable
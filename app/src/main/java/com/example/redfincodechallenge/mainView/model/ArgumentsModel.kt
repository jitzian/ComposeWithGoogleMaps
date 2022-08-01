package com.example.redfincodechallenge.mainView.model

import android.os.Parcelable
import com.example.redfincodechallenge.rest.model.ResultApiItem
import kotlinx.parcelize.Parcelize

/**
 * This class holds the data that will be passed through the navArgs using parcelable interface
 * */
@Parcelize
data class Items(val data: List<ResultApiItem>) : Parcelable
package com.example.redfincodechallenge.rest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location2(
    val humanAddress: String?,
    val latitude: String?,
    val longitude: String?
): Parcelable
package com.example.composeandgmaps.rest.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultApiItem(
    val addrDateCreate: String?,
    val addrDateModified: String?,
    val applicant: String?,
    val block: String?,
    val cnn: String?,
    val coldtruck: String?,
    val dayofweekstr: String?,
    val dayorder: String?,
    val end24: String?,
    val endtime: String?,
    val latitude: String?,
    val location: String?,
    val location2: Location2?,
    val locationdesc: String?,
    val locationid: String?,
    val longitude: String?,
    val lot: String?,
    val optionaltext: String?,
    val permit: String?,
    val start24: String?,
    val starttime: String?,
    val x: String?,
    val y: String?
) : Parcelable
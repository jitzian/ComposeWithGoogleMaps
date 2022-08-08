package com.example.composeandgmaps.detailView.model

data class MarkerData(
    val applicant: String = "",
    val location: String? = "",
    val locationid: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val locationDesc: String? = "",
    val optionalText: String? = ""
)
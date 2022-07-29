package com.example.redfincodechallenge.rest.model


import com.google.gson.annotations.SerializedName

data class Location2(
    @SerializedName("human_address")
    val humanAddress: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longitude")
    val longitude: String?
)
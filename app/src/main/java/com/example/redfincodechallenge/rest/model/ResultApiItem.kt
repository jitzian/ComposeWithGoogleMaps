package com.example.redfincodechallenge.rest.model


import com.google.gson.annotations.SerializedName

data class ResultApiItem(
    @SerializedName("addr_date_create")
    val addrDateCreate: String?,
    @SerializedName("addr_date_modified")
    val addrDateModified: String?,
    @SerializedName("applicant")
    val applicant: String?,
    @SerializedName("block")
    val block: String?,
    @SerializedName("cnn")
    val cnn: String?,
    @SerializedName("coldtruck")
    val coldtruck: String?,
    @SerializedName("dayofweekstr")
    val dayofweekstr: String?,
    @SerializedName("dayorder")
    val dayorder: String?,
    @SerializedName("end24")
    val end24: String?,
    @SerializedName("endtime")
    val endtime: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("location_2")
    val location2: Location2?,
    @SerializedName("locationdesc")
    val locationdesc: String?,
    @SerializedName("locationid")
    val locationid: String?,
    @SerializedName("longitude")
    val longitude: String?,
    @SerializedName("lot")
    val lot: String?,
    @SerializedName("optionaltext")
    val optionaltext: String?,
    @SerializedName("permit")
    val permit: String?,
    @SerializedName("start24")
    val start24: String?,
    @SerializedName("starttime")
    val starttime: String?,
    @SerializedName("x")
    val x: String?,
    @SerializedName("y")
    val y: String?
)
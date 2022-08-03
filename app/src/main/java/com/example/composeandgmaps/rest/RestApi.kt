package com.example.composeandgmaps.rest

import com.example.composeandgmaps.rest.model.ResultApi
import retrofit2.http.GET

interface RestApi {

    @GET("resource/jjew-r69b.json")
    suspend fun getData(): ResultApi

}
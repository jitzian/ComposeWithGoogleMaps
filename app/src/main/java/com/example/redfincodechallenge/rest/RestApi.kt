package com.example.redfincodechallenge.rest

import com.example.redfincodechallenge.rest.model.ResultApi
import retrofit2.http.GET

interface RestApi {

    @GET("resource/jjew-r69b.json")
    suspend fun getData(): ResultApi

}
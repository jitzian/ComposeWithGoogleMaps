package com.example.composeandgmaps.base

import androidx.lifecycle.ViewModel
import com.example.composeandgmaps.constants.GlobalConstants
import com.example.composeandgmaps.dagger.components.DaggerComponentInjector
import com.example.composeandgmaps.dagger.modules.NetworkModule
import com.example.composeandgmaps.rest.RestApi
import retrofit2.Retrofit
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    private val injector = DaggerComponentInjector.builder()
        .networkModule(NetworkModule(baseUrl = GlobalConstants.baseURl))
        .build()

    @Inject
    lateinit var retrofit: Retrofit

    lateinit var restApi: RestApi

    init {
        inject()
    }

    private fun inject() {
        injector.inject(this)
        restApi = retrofit.create(RestApi::class.java)
    }

}
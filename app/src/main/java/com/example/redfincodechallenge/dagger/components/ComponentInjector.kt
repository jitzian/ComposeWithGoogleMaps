package com.example.redfincodechallenge.dagger.components

import com.example.redfincodechallenge.base.BaseViewModel
import com.example.redfincodechallenge.dagger.modules.NetworkModule
import dagger.Component

@Component(
    modules = [
        NetworkModule::class
    ]
)
interface ComponentInjector {

    fun inject(baseViewModel: BaseViewModel)

    @Component.Builder
    interface Builder {
        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): ComponentInjector
    }

}
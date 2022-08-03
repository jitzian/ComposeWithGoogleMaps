package com.example.composeandgmaps.dagger.components

import com.example.composeandgmaps.base.BaseViewModel
import com.example.composeandgmaps.dagger.modules.NetworkModule
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
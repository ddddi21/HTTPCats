package com.example.httpcats.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.httpcats.di.VMFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: VMFactory): ViewModelProvider.Factory
}
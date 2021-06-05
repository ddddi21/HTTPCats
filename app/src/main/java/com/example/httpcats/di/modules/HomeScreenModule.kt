package com.example.httpcats.di.modules

import androidx.lifecycle.ViewModel
import com.example.httpcats.di.ViewModelKey
import com.example.httpcats.presenter.home.HomeScreenVM

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeScreenModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeScreenVM::class)
    fun bindLoginViewModel(viewModel: HomeScreenVM): ViewModel
}
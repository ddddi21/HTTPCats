package com.example.httpcats.di.modules

import androidx.lifecycle.ViewModel
import com.example.httpcats.di.ViewModelKey
import com.example.httpcats.presenter.apiActivity.ApiActivityVM

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ApiActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(ApiActivityVM::class)
    fun bindLoginViewModel(viewModel: ApiActivityVM): ViewModel
}
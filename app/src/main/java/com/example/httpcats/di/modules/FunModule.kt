package com.example.httpcats.di.modules

import androidx.lifecycle.ViewModel
import com.example.httpcats.di.ViewModelKey
import com.example.httpcats.presenter.`fun`.FunVM

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FunModule {

    @Binds
    @IntoMap
    @ViewModelKey(FunVM::class)
    fun bindLoginViewModel(viewModel: FunVM): ViewModel
}
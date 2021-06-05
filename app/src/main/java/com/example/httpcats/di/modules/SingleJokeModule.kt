package com.example.httpcats.di.modules

import androidx.lifecycle.ViewModel
import com.example.httpcats.di.ViewModelKey
import com.example.httpcats.presenter.apiActivity.ApiActivityVM
import com.example.httpcats.presenter.single.SingleJokeVm

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SingleJokeModule {

    @Binds
    @IntoMap
    @ViewModelKey(SingleJokeVm::class)
    fun bindLoginViewModel(viewModel: SingleJokeVm): ViewModel
}
package com.example.httpcats.di.modules

import androidx.lifecycle.ViewModel
import com.example.httpcats.di.ViewModelKey
import com.example.httpcats.presenter.apiActivity.ApiActivityVM
import com.example.httpcats.presenter.joke.JokesVM

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface JokeModule {

    @Binds
    @IntoMap
    @ViewModelKey(JokesVM::class)
    fun bindLoginViewModel(viewModel: JokesVM): ViewModel
}
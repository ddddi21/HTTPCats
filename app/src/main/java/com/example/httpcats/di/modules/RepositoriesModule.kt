package com.example.httpcats.di.modules

import com.example.httpcats.data.api.impl.ApiActivityRepositoryImpl
import com.example.httpcats.data.api.impl.JokeRepositoryImpl
import com.example.httpcats.data.api.request.BoredApi
import com.example.httpcats.data.api.request.JokeApi
import com.example.httpcats.domain.repository.ApiActivityRepository
import com.example.httpcats.domain.repository.JokeRepository
import com.example.httpcats.domain.repository.WordRepository

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {
    @Provides
    @Singleton
    fun provideWordRepo(): WordRepository = WordRepository

    @Provides
    @Singleton
    fun provideApiRepo(
        boredApi: BoredApi
    ): ApiActivityRepository = ApiActivityRepositoryImpl(boredApi)

    @Provides
    @Singleton
    fun provideJokeRepo(
        jokeApi: JokeApi
    ): JokeRepository= JokeRepositoryImpl(jokeApi)
}
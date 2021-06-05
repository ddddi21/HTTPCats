package com.example.httpcats.di.components

import android.app.Application
import com.example.httpcats.di.modules.*
import com.example.httpcats.presenter.`fun`.FunFragment
import com.example.httpcats.presenter.apiActivity.ApiActivityFragment
import com.example.httpcats.presenter.base.MainActivity
import com.example.httpcats.presenter.home.HomeScreenFragment
import com.example.httpcats.presenter.joke.JokesFragment
import com.example.httpcats.presenter.single.SingleJokeFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


//oh shit here we go again

@Component(
    modules = [ApiActivityModule::class, FunModule:: class, HomeScreenModule::class, JokeModule::class,
    NetModule::class, RepositoriesModule::class, SingleJokeModule::class, AndroidSupportInjectionModule::class,
        ViewModelFactoryModule::class]
)
@Singleton
interface MainAppComponent : AndroidInjector<Application> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): MainAppComponent
    }

    fun inject(fragment: ApiActivityFragment)
    fun inject(fragment: FunFragment)
    fun inject(fragment: JokesFragment)
    fun inject(fragment: SingleJokeFragment)
    fun inject(fragment: HomeScreenFragment)
    fun inject(activity: MainActivity)




}
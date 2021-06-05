package com.example.httpcats.presenter.base

import android.app.Application
import com.example.httpcats.di.components.DaggerMainAppComponent
import com.example.httpcats.di.components.MainAppComponent
class MyMainApplication : Application() {

    companion object {
        lateinit var appComponent: MainAppComponent
    }


    override fun onCreate() {
        super.onCreate()
        initDagger(this)
    }


    fun initDagger(app: Application) {
        appComponent = DaggerMainAppComponent.builder()
            .application(app)
            .build()
    }


}
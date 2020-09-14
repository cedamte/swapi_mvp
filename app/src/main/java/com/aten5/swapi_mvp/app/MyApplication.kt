package com.aten5.swapi_mvp.app

import android.app.Application
import com.aten5.swapi_mvp.BuildConfig
import com.aten5.swapi_mvp.di.AppComponent
import com.aten5.swapi_mvp.di.DaggerAppComponent
import timber.log.Timber

class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        appComponent.inject(this)
    }
}
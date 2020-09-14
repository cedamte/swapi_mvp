package com.aten5.swapi_mvp.app

import android.app.Application
import com.aten5.swapi_mvp.BuildConfig
import timber.log.Timber

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())

        }
    }
}
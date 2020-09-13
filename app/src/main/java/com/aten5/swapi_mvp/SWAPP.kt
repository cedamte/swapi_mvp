package com.aten5.swapi_mvp

import android.app.Application
import timber.log.Timber

class SWAPP : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())

        }
    }
}
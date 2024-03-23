package com.fadlurahmanf.starterappcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
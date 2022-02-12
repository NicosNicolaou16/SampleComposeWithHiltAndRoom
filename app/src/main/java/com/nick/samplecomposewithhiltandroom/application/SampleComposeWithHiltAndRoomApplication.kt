package com.nick.samplecomposewithhiltandroom.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SampleComposeWithHiltAndRoomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
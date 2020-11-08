package com.example.turkishtourguide

import android.app.Application
import com.example.turkishtourguide.di.networkModule
import com.example.turkishtourguide.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HomeApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@HomeApp)
            modules(networkModule)
            modules(viewModelModule)
        }
    }
}
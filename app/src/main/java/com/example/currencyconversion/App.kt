package com.example.currencyconversion

import android.app.Application
import com.example.currencyconversion.data.di.DataModules
import com.example.currencyconversion.domain.di.DomainModule
import com.example.currencyconversion.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModules.load()
        DomainModule.load()
        PresentationModule.load()
    }
}
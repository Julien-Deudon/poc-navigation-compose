package com.decathlon.pocreturn

import org.koin.core.context.startKoin

import android.app.Application
import com.decathlon.pocreturn.returns.productModule
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(productModule)
        }
    }
}

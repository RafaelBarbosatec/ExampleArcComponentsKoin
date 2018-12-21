package com.rafaelbarbosatec.testekoin

import android.app.Application
import com.rafaelbarbosatec.testekoin.di.Modules
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(Modules.appModule,Modules.domainModule,Modules.viewModelModule))
    }
}
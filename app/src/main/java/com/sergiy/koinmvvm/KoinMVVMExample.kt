package com.sergiy.koinmvvm

import android.app.Application
import com.sergiy.koinmvvm.injection.appModule
import com.sergiy.koinmvvm.injection.networkModule
import com.sergiy.koinmvvm.injection.repositoryModule
import com.sergiy.koinmvvm.injection.useCasesModule
import com.sergiy.koinmvvm.utils.ToastUtils.showToast
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinMVVMExample : Application() {

    override fun onCreate() {
        super.onCreate()

        setInjectionConfig()
        showToast(this, getString(R.string.welcome_message))
    }

    private fun setInjectionConfig() {
        startKoin {
            androidContext(this@KoinMVVMExample)
            androidLogger()
            modules(
                listOf(
                    appModule,
                    networkModule,
                    repositoryModule,
                    useCasesModule
                )
            )
        }
    }

}
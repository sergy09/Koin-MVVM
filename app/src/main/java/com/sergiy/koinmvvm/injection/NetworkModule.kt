package com.sergiy.koinmvvm.injection

import com.sergiy.koinmvvm.data_source.api.MockInterceptor
import com.sergiy.koinmvvm.data_source.api.provideForecastApi
import com.sergiy.koinmvvm.data_source.api.provideOkHttpClient
import com.sergiy.koinmvvm.data_source.api.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    factory { MockInterceptor(get()) }
    factory { provideOkHttpClient(get()) }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}
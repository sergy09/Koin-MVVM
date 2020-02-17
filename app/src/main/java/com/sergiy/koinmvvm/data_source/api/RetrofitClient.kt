package com.sergiy.koinmvvm.data_source.api

import com.sergiy.koinmvvm.BuildConfig.API_SAMPLE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(API_SAMPLE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun provideOkHttpClient(mockInterceptor: MockInterceptor): OkHttpClient =
    OkHttpClient().newBuilder()
        .addInterceptor(mockInterceptor)
        .build()

fun provideForecastApi(retrofit: Retrofit): ApiDataSource =
    retrofit.create(ApiDataSource::class.java)
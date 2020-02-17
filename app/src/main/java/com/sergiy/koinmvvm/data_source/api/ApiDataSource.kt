package com.sergiy.koinmvvm.data_source.api

import com.sergiy.koinmvvm.business.model.ChannelList
import retrofit2.Call
import retrofit2.http.GET


interface ApiDataSource {

    @GET("channels")
    fun getChannelList(): Call<ChannelList>

    //@GET("channels")
    //fun getChannelList(): Call<ChannelList>

    //@GET("channels")
    //fun getChannelList(): Call<ChannelList>

}


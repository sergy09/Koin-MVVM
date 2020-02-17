package com.sergiy.koinmvvm.data_source.repositories.channel_list

import com.sergiy.koinmvvm.business.model.ChannelList
import com.sergiy.koinmvvm.data_source.api.ApiDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetChannelListRemoteRepository(private val apiDataSource: ApiDataSource) {

    fun getChannelList(onSuccess: (ChannelList) -> Unit, onError: (Throwable) -> Unit) {
        apiDataSource.getChannelList().enqueue(object : Callback<ChannelList> {
            override fun onFailure(call: Call<ChannelList>, t: Throwable) = onError(t)

            override fun onResponse(call: Call<ChannelList>, response: Response<ChannelList>) =
                //Process response if necessary
                response.body()?.let(onSuccess) ?: onSuccess(ChannelList(listOf()))
        })
    }

}


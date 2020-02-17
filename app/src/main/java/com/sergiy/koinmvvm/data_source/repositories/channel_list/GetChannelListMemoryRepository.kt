package com.sergiy.koinmvvm.data_source.repositories.channel_list

import com.sergiy.koinmvvm.business.errors.DataNotFoundException
import com.sergiy.koinmvvm.business.model.ChannelList
import com.sergiy.koinmvvm.data_source.BaseMemoryRepository


class GetChannelListMemoryRepository: BaseMemoryRepository<ChannelList>() {

    fun getChannelList(onSuccess: (ChannelList) -> Unit, onError: (Throwable) -> Unit) =
        get()?.let(onSuccess) ?: onError(DataNotFoundException())

    fun saveChannelList(channelList: ChannelList) = save(channelList)
}


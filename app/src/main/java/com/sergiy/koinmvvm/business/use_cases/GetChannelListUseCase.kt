package com.sergiy.koinmvvm.business.use_cases

import com.sergiy.koinmvvm.business.model.ChannelList
import com.sergiy.koinmvvm.data_source.repositories.channel_list.GetChannelListRepository

class GetChannelListUseCase(private val repository: GetChannelListRepository) {

    fun getChannelList(onSuccess: (ChannelList) -> Unit, onError: (Throwable) -> Unit) =
        repository.getChannelList(onSuccess, onError)

}

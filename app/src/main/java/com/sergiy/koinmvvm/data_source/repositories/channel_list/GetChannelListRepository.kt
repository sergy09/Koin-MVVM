package com.sergiy.koinmvvm.data_source.repositories.channel_list

import com.sergiy.koinmvvm.business.model.ChannelList


class GetChannelListRepository(
    private val getChannelListRemoteRepository: GetChannelListRemoteRepository,
    private val getChannelListMemoryRepository: GetChannelListMemoryRepository) {

    fun getChannelList(onSuccess: (ChannelList) -> Unit, onError: (Throwable) -> Unit) {
        getChannelListMemoryRepository.getChannelList(onSuccess, {
            retrieveChannelList(onSuccess, onError)
        })
    }

    private fun retrieveChannelList(onSuccess: (ChannelList) -> Unit, onError: (Throwable) -> Unit) {
        getChannelListRemoteRepository.getChannelList({
            getChannelListMemoryRepository.saveChannelList(it)
            onSuccess(it)
        }, onError)
    }

}


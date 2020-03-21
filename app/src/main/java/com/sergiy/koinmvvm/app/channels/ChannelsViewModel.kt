package com.sergiy.koinmvvm.app.channels

import com.sergiy.koinmvvm.app.channels.ChannelsViewModel.Category.*
import com.sergiy.koinmvvm.app.common.BaseViewModel
import com.sergiy.koinmvvm.business.model.Channel
import com.sergiy.koinmvvm.business.model.ChannelList
import com.sergiy.koinmvvm.business.use_cases.GetChannelListUseCase

class ChannelsViewModel(
    private val getChannelListUseCase: GetChannelListUseCase
) : BaseViewModel() {

    private var channelList: ChannelList? = null
    private var channels = listOf<Channel>()

    fun loadChannelList(onSuccess: (List<Channel>?) -> Unit, onError: (Throwable) -> Unit) {
        loader?.setProgress(true)
        getChannelListUseCase.getChannelList({
            channelList = it
            onSuccess(it.list)
        }, onError)
    }

    fun filterByCategory(category: Category?, onSuccess: (List<Channel>?) -> Unit) {
        when (category) {
            DEFAULT -> {
                onSuccess(channelList?.list)
                loader?.setProgress(false)
            }
            CINEMA -> {
                channels = channelList?.list?.filter {
                    it.category == "Cine" //Should be replaced by enum of category list
                } ?: listOf()

                onSuccess(channels)
                loader?.setProgress(false)
            }
            ORGANIZED -> {
                channels = channelList?.list?.sortedBy { it.name } ?: listOf()

                onSuccess(channels)
                loader?.setProgress(false)
            }
        }

    }

    fun updateChannelName(channel: Channel, onSuccess: (List<Channel>?) -> Unit) {
        channels = if (channels.isNotEmpty())
            channels.map {
                if (it == channel)
                    it.copy(isSelected = !it.isSelected)
                else
                    it
            }
        else channelList?.list?.map {
            if (it == channel)
                it.copy(isSelected = !it.isSelected)
            else
                it
        } ?: listOf()

        channelList = ChannelList(channelList?.list?.map { c ->
            channels.find { c.id == it.id } ?: c
        } ?: listOf())

        onSuccess(channels)
    }

    enum class Category(val code: Int) {
        DEFAULT(0),
        CINEMA(1),
        ORGANIZED(2);

        companion object {
            private val map = values().associateBy(Category::code)
            operator fun invoke(type: Int) = map[type]
            internal fun getList() = values().toList()
        }
    }

}
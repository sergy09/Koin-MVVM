package com.sergiy.koinmvvm.app.channels

import com.sergiy.koinmvvm.app.channels.ChannelsViewModel.Category.CINEMA
import com.sergiy.koinmvvm.app.channels.ChannelsViewModel.Category.DEFAULT
import com.sergiy.koinmvvm.business.model.ChannelList
import com.sergiy.koinmvvm.business.use_cases.GetChannelListUseCase

class ChannelsViewModel(private val getChannelListUseCase: GetChannelListUseCase) {

    private var channelList: ChannelList? = null

    fun loadChannelList(onSuccess: (ChannelList) -> Unit, onError: (Throwable) -> Unit) =
        getChannelListUseCase.getChannelList({
            channelList = it
            onSuccess(it)
        }, onError)

    fun filterByCategory(category: Category?, onSuccess: (ChannelList?) -> Unit) {
        when (category) {
            DEFAULT -> {
                onSuccess(channelList)
            }
            CINEMA -> {
                val list = channelList?.list?.filter {
                    it.category == "Cine" //Should be replaced by enum of category list
                } ?: listOf()
                onSuccess(ChannelList(list))
            }
        }

    }

    enum class Category(val code: Int) {
        DEFAULT(0),
        CINEMA(1);

        companion object {
            private val map = values().associateBy(Category::code)
            operator fun invoke(type: Int) = map[type]
        }
    }

}
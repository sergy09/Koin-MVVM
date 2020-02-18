package com.sergiy.koinmvvm.app.channels

import com.sergiy.koinmvvm.app.channels.ChannelsViewModel.Category.CINEMA
import com.sergiy.koinmvvm.app.channels.ChannelsViewModel.Category.DEFAULT
import com.sergiy.koinmvvm.app.common.BaseViewModel
import com.sergiy.koinmvvm.business.model.ChannelList
import com.sergiy.koinmvvm.business.use_cases.GetChannelListUseCase
import kotlin.reflect.KFunction0

class ChannelsViewModel(private val getChannelListUseCase: GetChannelListUseCase): BaseViewModel() {

    private var channelList: ChannelList? = null

    fun loadChannelList(onSuccess: (ChannelList) -> Unit, onError: (Throwable) -> Unit) {
        loader?.setProgress(true)
        getChannelListUseCase.getChannelList({
            channelList = it
            onSuccess(it)
        }, onError)
    }

    fun filterByCategory(category: Category?, onSuccess: (ChannelList?) -> Unit) {
        when (category) {
            DEFAULT -> {
                onSuccess(channelList)
                loader?.setProgress(false)
            }
            CINEMA -> {
                val list = channelList?.list?.filter {
                    it.category == "Cine" //Should be replaced by enum of category list
                } ?: listOf()
                onSuccess(ChannelList(list))
                loader?.setProgress(false)
            }
        }

    }

    enum class Category(val code: Int) {
        DEFAULT(0),
        CINEMA(1);

        companion object {
            private val map = values().associateBy(Category::code)
            operator fun invoke(type: Int) = map[type]
            internal fun getList() = values().toList()
        }

    }

}
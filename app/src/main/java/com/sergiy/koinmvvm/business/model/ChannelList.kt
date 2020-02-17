package com.sergiy.koinmvvm.business.model

import com.google.gson.annotations.SerializedName

data class ChannelList(
    @SerializedName("response")
    val list: List<Channel>
)
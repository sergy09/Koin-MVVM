package com.sergiy.koinmvvm.business.model

import com.google.gson.annotations.SerializedName

data class Attachment(
    @SerializedName("value")
    val imageUrl: String
)

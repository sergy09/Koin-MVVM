package com.sergiy.koinmvvm.business.model

data class Channel(
    val id: Float,
    val name: String,
    val category: String,
    val attachments: List<Attachment>,
    val isSelected: Boolean = false
)
package com.sergiy.koinmvvm.utils.extensions

import android.widget.ImageView
import com.sergiy.koinmvvm.BuildConfig.START_IMAGE_URL
import com.squareup.picasso.Picasso

fun ImageView?.loadChannelImage(url: String?) {
    this?.let {
        url?.let { Picasso.get().load(START_IMAGE_URL + it).into(this) } ?: run {
            //Set default image
        }
    }
}
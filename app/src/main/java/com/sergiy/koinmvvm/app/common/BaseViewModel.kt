package com.sergiy.koinmvvm.app.common

abstract class BaseViewModel {

    interface Loader {
        fun setProgress(isLoading: Boolean)
    }

    var loader: Loader? = null

}
package com.sergiy.koinmvvm.data_source

abstract class BaseMemoryRepository<T> {

    private var data: T? = null

    fun save(data: T) {
        this.data = data
    }

    fun get(): T? = data

    fun invalidate() {
        data = null
    }
}
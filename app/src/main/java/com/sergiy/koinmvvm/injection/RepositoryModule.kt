package com.sergiy.koinmvvm.injection

import com.sergiy.koinmvvm.data_source.repositories.channel_list.GetChannelListMemoryRepository
import com.sergiy.koinmvvm.data_source.repositories.channel_list.GetChannelListRemoteRepository
import com.sergiy.koinmvvm.data_source.repositories.channel_list.GetChannelListRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { GetChannelListRepository(get(), get()) }
    single { GetChannelListMemoryRepository() }
    factory { GetChannelListRemoteRepository(get()) }

    //single { OtherRepository(get()) }
    //single { OtherRepository(get()) }
    //single { OtherRepository(get()) }
}
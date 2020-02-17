package com.sergiy.koinmvvm.injection

import com.sergiy.koinmvvm.app.channels.ChannelsActivity
import com.sergiy.koinmvvm.app.channels.ChannelsViewModel
import com.sergiy.koinmvvm.app.main.MainActivity
import com.sergiy.koinmvvm.app.main.MainNavigator
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    //Your app componets, activities, fragments & viewModels
    scope(named<ChannelsActivity>()) {
        scoped { ChannelsViewModel(get()) }
    }
    //Sample with navigator pattern
    scope(named<MainActivity>()) {
        scoped { MainNavigator() }
    }
    //To test ChannelsViewModel integration
    factory { ChannelsViewModel(get()) }
    // scope(named<OtherActivity>()) {
    //     scoped { OtherActivityPresenter(get()) }
    // }
    // scope(named<OtherFragmentActivity>()) {
    //     scoped { OtherFragmentPresenter(get()) }
    // }
    // factory(named<OtherCustomView>()) {
    //     scoped { OtherFragmentPresenter(get()) }
    // }
}
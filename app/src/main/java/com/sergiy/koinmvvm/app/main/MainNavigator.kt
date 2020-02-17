package com.sergiy.koinmvvm.app.main

import android.content.Intent
import com.sergiy.koinmvvm.app.channels.ChannelsActivity
import com.sergiy.koinmvvm.app.common.BaseNavigator
import com.sergiy.koinmvvm.app.main.MainNavigator.Screens.CHANNEL_LIST

class MainNavigator : BaseNavigator() {

    enum class Screens {
        CHANNEL_LIST
    }

    internal fun navigateTo(activity: MainActivity, screen: Screens) {
        when (screen) {
            CHANNEL_LIST -> showChannels(activity)
        }
    }

    private fun showChannels(activity: MainActivity) {
        val channelIntent = Intent(activity, ChannelsActivity::class.java)
        activity.goToActivity(channelIntent)
    }

}
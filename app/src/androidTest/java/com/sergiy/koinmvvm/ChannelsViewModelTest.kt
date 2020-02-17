package com.sergiy.koinmvvm

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sergiy.koinmvvm.app.channels.ChannelsViewModel
import com.sergiy.koinmvvm.app.channels.ChannelsViewModel.Category.CINEMA
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject
import java.lang.Thread.sleep

@RunWith(AndroidJUnit4::class)
class ChannelsViewModelTest : KoinTest {

    private val viewModel: ChannelsViewModel by inject()

    @Test
    fun get_channel_default_list_size_ok() {
        viewModel.loadChannelList({
            assertEquals(96, it.list.size)
        }, {})
        sleep(1000)
    }

    @Test
    fun get_channel_filtered_list_size_ok() {
        viewModel.loadChannelList({}, {})
        sleep(1000)
        viewModel.filterByCategory(CINEMA) {
            assertEquals(8, it?.list?.size)
        }
    }

}
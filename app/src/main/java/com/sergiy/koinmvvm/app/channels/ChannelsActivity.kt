package com.sergiy.koinmvvm.app.channels

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.sergiy.koinmvvm.R
import com.sergiy.koinmvvm.app.channels.ChannelsViewModel.Category
import com.sergiy.koinmvvm.app.common.BaseActivity
import com.sergiy.koinmvvm.app.common.SpinnerListener
import com.sergiy.koinmvvm.business.model.Channel
import com.sergiy.koinmvvm.business.model.ChannelList
import com.sergiy.koinmvvm.utils.ToastUtils.showToast
import kotlinx.android.synthetic.main.activity_channels.*
import org.koin.android.scope.currentScope

class ChannelsActivity : BaseActivity() {

    companion object {
        const val CHANNELS_COLUMNS = 4
    }

    private val viewModel: ChannelsViewModel by currentScope.inject()
    private val adapter = ChannelsRvAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channels)

        viewModel.loader = this
        viewModel.loadChannelList(this::showChannelList, this::showError)
    }

    override fun onStart() {
        super.onStart()
        initListeners()
        setRecycleView()
        setCategoryFilter()
    }
    private fun initListeners() {
        adapter.listener = { channel ->
            showToast(this, channel.name)
            viewModel.updateChannelName(channel, this::showChannelList)
        }
        sCategoryFilter?.onItemSelectedListener = SpinnerListener { position ->
            viewModel.filterByCategory(Category(position), this::showChannelList)
        }
    }
    private fun setRecycleView() {
        rvChannelList?.layoutManager = GridLayoutManager(this, CHANNELS_COLUMNS)
        rvChannelList?.adapter = adapter
    }
    private fun setCategoryFilter() {
        sCategoryFilter?.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.getList())
    }
    private fun showChannelList(channelList: List<Channel>?) {
        channelList?.let(adapter::updateList)
        rvChannelList.scrollToPosition(0)
    }

}

package com.sergiy.koinmvvm.app.channels

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.sergiy.koinmvvm.R
import com.sergiy.koinmvvm.app.channels.ChannelsViewModel.Category
import com.sergiy.koinmvvm.app.common.BaseActivity
import com.sergiy.koinmvvm.app.common.BaseRvAdapter.BaseRvAdapterListener
import com.sergiy.koinmvvm.business.model.Channel
import com.sergiy.koinmvvm.business.model.ChannelList
import com.sergiy.koinmvvm.utils.ToastUtils.showToast
import kotlinx.android.synthetic.main.activity_channels.*
import org.koin.android.scope.currentScope

class ChannelsActivity : BaseActivity(), BaseRvAdapterListener<Channel> {

    companion object {
        const val CHANNELS_COLUMNS = 4
    }

    private val viewModel: ChannelsViewModel by currentScope.inject()
    private val adapter = ChannelsRvAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channels)

        viewModel.loadChannelList(this::showChannelList, this::showError)
    }

    override fun onStart() {
        super.onStart()
        setRecycleView()
        setCategoryFilter()
    }
    private fun setRecycleView() {
        rvChannelList?.layoutManager = GridLayoutManager(this, CHANNELS_COLUMNS)
        adapter.listener = this
        rvChannelList?.adapter = adapter
    }

    private fun setCategoryFilter() {
        sCategoryFilter?.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.values().toList())
        sCategoryFilter?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                viewModel.filterByCategory(Category(position), this@ChannelsActivity::showChannelList)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun showChannelList(channelList: ChannelList?) {
        channelList?.list?.let(adapter::updateList)
    }

    override fun onItemClick(entity: Channel) {
        showToast(this, entity.name)
    }

}

package com.sergiy.koinmvvm.app.channels

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sergiy.koinmvvm.R
import com.sergiy.koinmvvm.app.channels.ChannelsRvAdapter.ViewHolder
import com.sergiy.koinmvvm.app.common.BaseRvAdapter
import com.sergiy.koinmvvm.business.model.Channel
import com.sergiy.koinmvvm.utils.extensions.inflate
import com.sergiy.koinmvvm.utils.extensions.loadChannelImage
import kotlinx.android.synthetic.main.item_channel.view.*

class ChannelsRvAdapter : BaseRvAdapter<Channel, ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_channel))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position], listener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Channel, listener: BaseRvAdapterListener<Channel>?) {
            with(itemView) {
                item.attachments.firstOrNull()?.imageUrl?.let(ivChannelImage::loadChannelImage) ?: run {
                    Log.d("EMPTY", "EMPTY")
                }
                tvChannelName?.text = item.name
                tvChannelName?.setOnClickListener {
                    listener?.onItemClick(item)
                }
            }
        }
    }

}
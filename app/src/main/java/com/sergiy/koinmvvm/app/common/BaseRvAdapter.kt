package com.sergiy.koinmvvm.app.common

import androidx.recyclerview.widget.DiffUtil.Callback
import androidx.recyclerview.widget.DiffUtil.calculateDiff
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRvAdapter<E, VH : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<VH>() {

    protected var items = listOf<E>()
    lateinit var listener: (E) -> Unit

    internal fun updateList(newList: List<E>) {
        val diffResult = calculateDiff(DiffCallback(newList, items), true)
        items = newList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = items.size

    private inner class DiffCallback<E>(val newList: List<E>, val oldList: List<E>) : Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]
    }

}
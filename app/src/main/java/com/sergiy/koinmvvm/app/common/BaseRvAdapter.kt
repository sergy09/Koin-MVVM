package com.sergiy.koinmvvm.app.common

import androidx.recyclerview.widget.DiffUtil.Callback
import androidx.recyclerview.widget.DiffUtil.calculateDiff
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRvAdapter<E, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    interface BaseRvAdapterListener<E> {
        fun onItemClick(entity: E)
    }

    internal var items = listOf<E>()
    internal var listener: BaseRvAdapterListener<E>? = null

    internal fun updateList(newList: List<E>) {
        val diffResult = calculateDiff(MyDiffCallback(newList, items))
        items = newList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = items.size

    class MyDiffCallback<E>(newPersons: List<E>, oldPersons: List<E>) : Callback() {
        var oldList: List<E> = oldPersons
        var newList: List<E> = newPersons

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] === newList[newItemPosition]

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition]?.equals(newList[newItemPosition]) ?: false

    }

}
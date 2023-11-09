package org.alexcawl.memorize.ui

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DAdapterItemDiffCallback : DiffUtil.ItemCallback<DAdapterItem>() {
    override fun areItemsTheSame(
        oldItem: DAdapterItem,
        newItem: DAdapterItem
    ): Boolean = oldItem::class == newItem::class && oldItem.diffId == newItem.diffId

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: DAdapterItem,
        newItem: DAdapterItem
    ): Boolean = oldItem.diffContent == newItem.diffContent

    override fun getChangePayload(
        oldItem: DAdapterItem,
        newItem: DAdapterItem
    ): Any = oldItem.onChangePayload(newItem)
}
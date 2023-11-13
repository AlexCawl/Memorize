package org.alexcawl.memorize.ui.delegates

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class DelegateViewHolder<M, B : ViewBinding>(
    private val binding: B
) : RecyclerView.ViewHolder(binding.root) {
    abstract fun onBind(model: M)
}
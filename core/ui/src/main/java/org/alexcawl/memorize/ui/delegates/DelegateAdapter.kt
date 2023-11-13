package org.alexcawl.memorize.ui.delegates

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class DelegateAdapter<M, B : ViewBinding, in VH : DelegateViewHolder<M, B>>(
    val modelClass: Class<out M>
) {
    abstract fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    open fun bindViewHolder(
        model: M,
        viewHolder: VH
    ) = viewHolder.onBind(model)

    open fun onViewRecycled(viewHolder: VH) = Unit
    open fun onViewDetachedFromWindow(viewHolder: VH) = Unit
    open fun onViewAttachedToWindow(viewHolder: VH) = Unit
}
package org.alexcawl.memorize.ui.delegates

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CompositeAdapter<M : Any> private constructor(
    private val adapters: List<DelegateAdapter<M, RecyclerView.ViewHolder>>,
    callback: DiffUtil.ItemCallback<M>
) : ListAdapter<M, RecyclerView.ViewHolder>(callback) {
    class Builder<M : Any>(
        private val callback: DiffUtil.ItemCallback<M>
    ) {
        private val adapters: MutableList<DelegateAdapter<M, RecyclerView.ViewHolder>> = mutableListOf()

        @Suppress("UNCHECKED_CAST")
        fun add(adapter: DelegateAdapter<*, *>): Builder<M> {
            adapters.add(adapter as DelegateAdapter<M, RecyclerView.ViewHolder>)
            return this
        }

        fun build(): CompositeAdapter<M> {
            require(adapters.isNotEmpty()) { "Register at least one adapter!" }
            return CompositeAdapter(adapters, callback)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return adapters[viewType].createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindViewHolder(holder, position, mutableListOf())
    }

    override fun getItemViewType(position: Int): Int {
        for (i in adapters.indices) {
            if (adapters[i].modelClass == getItem(position).javaClass) {
                return i
            }
        }
        throw NullPointerException("Can not get viewType for position $position!")
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        val delegateAdapter = adapters[getItemViewType(position)]
        delegateAdapter.bindViewHolder(getItem(position), holder)
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        adapters[holder.itemViewType].onViewRecycled(holder)
        super.onViewRecycled(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        adapters[holder.itemViewType].onViewDetachedFromWindow(holder)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        adapters[holder.itemViewType].onViewAttachedToWindow(holder)
        super.onViewAttachedToWindow(holder)
    }
}
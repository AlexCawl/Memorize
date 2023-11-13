package org.alexcawl.memorize.ui.delegates

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding

class CompositeAdapter<M : Any> private constructor(
    private val adapters: List<DelegateAdapter<M, ViewBinding, DelegateViewHolder<M, ViewBinding>>>,
    callback: DiffUtil.ItemCallback<M>
) : ListAdapter<M, DelegateViewHolder<M, ViewBinding>>(callback) {
    inner class Builder(
        private val callback: DiffUtil.ItemCallback<M>
    ) {
        private val adapters: MutableList<DelegateAdapter<M, ViewBinding, DelegateViewHolder<M, ViewBinding>>> =
            mutableListOf()

        fun add(adapter: DelegateAdapter<M, ViewBinding, DelegateViewHolder<M, ViewBinding>>): Builder {
            adapters.add(adapter)
            return this
        }

        fun build(): CompositeAdapter<M> {
            require(adapters.isNotEmpty()) { "Register at least one adapter" }
            return CompositeAdapter(adapters, callback)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DelegateViewHolder<M, ViewBinding> {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DelegateViewHolder<M, ViewBinding>, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        for (i in adapters.indices) {
            if (adapters[i].modelClass == getItem(position).javaClass) {
                return i
            }
        }
        throw NullPointerException("Can not get viewType for position $position")
    }

    override fun onBindViewHolder(
        holder: DelegateViewHolder<M, ViewBinding>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        val delegateAdapter = adapters[getItemViewType(position)]
        delegateAdapter.bindViewHolder(getItem(position), holder)
    }

    override fun onViewRecycled(holder: DelegateViewHolder<M, ViewBinding>) {
        adapters[holder.itemViewType].onViewRecycled(holder)
        super.onViewRecycled(holder)
    }

    override fun onViewDetachedFromWindow(holder: DelegateViewHolder<M, ViewBinding>) {
        adapters[holder.itemViewType].onViewDetachedFromWindow(holder)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewAttachedToWindow(holder: DelegateViewHolder<M, ViewBinding>) {
        adapters[holder.itemViewType].onViewAttachedToWindow(holder)
        super.onViewAttachedToWindow(holder)
    }
}
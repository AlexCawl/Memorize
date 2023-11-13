package org.alexcawl.memorize.newsline.ui.util.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.memorize.newsline.databinding.LayoutTagBinding
import org.alexcawl.memorize.newsline.domain.Filter
import org.alexcawl.memorize.ui.delegates.DelegateAdapter
import org.alexcawl.memorize.ui.delegates.DelegateViewHolder

object QueryAdapter : DelegateAdapter<Filter.Query, QueryAdapter.QueryViewHolder>(
    Filter.Query::class.java
) {
    class QueryViewHolder(
        binding: LayoutTagBinding
    ) : DelegateViewHolder<Filter.Query, LayoutTagBinding>(binding) {
        override fun onBind(model: Filter.Query) {
            binding.tagTitle.text = model.content
        }
    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutTagBinding.inflate(inflater, parent, false)
        return QueryViewHolder(binding)
    }

    override fun bindViewHolder(model: Filter.Query, viewHolder: QueryViewHolder) =
        viewHolder.onBind(model)
}
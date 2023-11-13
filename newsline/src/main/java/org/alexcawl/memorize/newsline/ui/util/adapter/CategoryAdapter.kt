package org.alexcawl.memorize.newsline.ui.util.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.memorize.newsline.databinding.LayoutTagBinding
import org.alexcawl.memorize.newsline.domain.Filter
import org.alexcawl.memorize.ui.delegates.DelegateAdapter
import org.alexcawl.memorize.ui.delegates.DelegateViewHolder

object CategoryAdapter : DelegateAdapter<Filter.Category, CategoryAdapter.CategoryViewHolder>(
    Filter.Category::class.java
) {
    class CategoryViewHolder(
        binding: LayoutTagBinding
    ) : DelegateViewHolder<Filter.Category, LayoutTagBinding>(binding) {
        override fun onBind(model: Filter.Category) {
            binding.tagTitle.text = model.content
        }
    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutTagBinding.inflate(inflater, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun bindViewHolder(model: Filter.Category, viewHolder: CategoryViewHolder) =
        viewHolder.onBind(model)
}
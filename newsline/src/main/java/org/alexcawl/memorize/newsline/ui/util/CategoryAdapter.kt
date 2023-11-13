package org.alexcawl.memorize.newsline.ui.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.memorize.newsline.databinding.LayoutTagBinding
import org.alexcawl.memorize.newsline.domain.Filter
import org.alexcawl.memorize.ui.DelegateAdapter
import org.alexcawl.memorize.ui.DelegateAdapterItem

class CategoryAdapter : DelegateAdapter<Filter.Category, CategoryAdapter.CategoryViewHolder>(Filter.Category::class.java) {
    inner class CategoryViewHolder(
        private val binding: LayoutTagBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: Filter.Category) {
            binding.tagTitle.text = model.description
        }
    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutTagBinding.inflate(inflater, parent, false)
        return CategoryViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Filter.Category,
        viewHolder: CategoryViewHolder,
        payloads: List<DelegateAdapterItem.Payload>
    ) = viewHolder.onBind(model)
}
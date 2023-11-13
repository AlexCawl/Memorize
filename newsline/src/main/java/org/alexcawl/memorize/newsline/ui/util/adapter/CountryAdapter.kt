package org.alexcawl.memorize.newsline.ui.util.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.memorize.newsline.databinding.LayoutTagBinding
import org.alexcawl.memorize.newsline.domain.Filter
import org.alexcawl.memorize.ui.delegates.DelegateAdapter
import org.alexcawl.memorize.ui.delegates.DelegateViewHolder

object CountryAdapter : DelegateAdapter<Filter.Country, CountryAdapter.CountryViewHolder>(
    Filter.Country::class.java
) {
    class CountryViewHolder(
        binding: LayoutTagBinding
    ) : DelegateViewHolder<Filter.Country, LayoutTagBinding>(binding) {
        override fun onBind(model: Filter.Country) {
            binding.tagTitle.text = model.content
        }
    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutTagBinding.inflate(inflater, parent, false)
        return CountryViewHolder(binding)
    }

    override fun bindViewHolder(model: Filter.Country, viewHolder: CountryViewHolder) =
        viewHolder.onBind(model)
}
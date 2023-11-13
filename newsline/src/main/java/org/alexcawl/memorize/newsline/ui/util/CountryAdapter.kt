package org.alexcawl.memorize.newsline.ui.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.memorize.newsline.databinding.LayoutTagBinding
import org.alexcawl.memorize.newsline.domain.Filter
import org.alexcawl.memorize.ui.DelegateAdapter
import org.alexcawl.memorize.ui.DelegateAdapterItem

class CountryAdapter : DelegateAdapter<Filter.Country, CountryAdapter.CountryViewHolder>(Filter.Country::class.java) {
    inner class CountryViewHolder(
        private val binding: LayoutTagBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: Filter.Country) {
            binding.tagTitle.text = model.description
        }
    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutTagBinding.inflate(inflater, parent, false)
        return CountryViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Filter.Country,
        viewHolder: CountryViewHolder,
        payloads: List<DelegateAdapterItem.Payload>
    ) = viewHolder.onBind(model)
}
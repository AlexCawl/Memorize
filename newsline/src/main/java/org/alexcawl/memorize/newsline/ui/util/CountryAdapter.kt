package org.alexcawl.memorize.newsline.ui.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.memorize.newsline.databinding.LayoutCountryBinding
import org.alexcawl.memorize.newsline.domain.Filter
import org.alexcawl.memorize.ui.DAdapter
import org.alexcawl.memorize.ui.DAdapterItem

class CountryAdapter :
    DAdapter<Filter.Country, CountryAdapter.CountryViewHolder>(Filter.Country::class.java) {
    inner class CountryViewHolder(
        private val binding: LayoutCountryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(country: Filter.Country) {
            binding.countryTitle.text = country.description
        }
    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutCountryBinding.inflate(inflater, parent, false)
        return CountryViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Filter.Country,
        viewHolder: CountryViewHolder,
        payloads: List<DAdapterItem.Payload>
    ) = viewHolder.onBind(model)
}
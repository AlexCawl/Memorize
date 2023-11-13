package org.alexcawl.memorize.newsline.ui.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.memorize.newsline.databinding.LayoutTagBinding
import org.alexcawl.memorize.newsline.domain.Filter
import org.alexcawl.memorize.ui.DelegateAdapter
import org.alexcawl.memorize.ui.DelegateAdapterItem

class SourceAdapter : DelegateAdapter<Filter.Source, SourceAdapter.SourceViewHolder>(Filter.Source::class.java) {
    inner class SourceViewHolder(
        private val binding: LayoutTagBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: Filter.Source) {
            binding.tagTitle.text = model.description
        }
    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutTagBinding.inflate(inflater, parent, false)
        return SourceViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Filter.Source,
        viewHolder: SourceViewHolder,
        payloads: List<DelegateAdapterItem.Payload>
    ) = viewHolder.onBind(model)
}
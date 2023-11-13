package org.alexcawl.memorize.newsline.ui.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.memorize.newsline.databinding.LayoutActionButtonBinding
import org.alexcawl.memorize.newsline.domain.SearchMode
import org.alexcawl.memorize.ui.DelegateAdapter
import org.alexcawl.memorize.ui.DelegateAdapterItem

class ActionIconAdapter : DelegateAdapter<SearchMode.ActionIcon, ActionIconAdapter.ActionIconViewHolder>(SearchMode.ActionIcon::class.java) {
    inner class ActionIconViewHolder(
        private val binding: LayoutActionButtonBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: SearchMode.ActionIcon) {

        }
    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutActionButtonBinding.inflate(inflater, parent, false)
        return ActionIconViewHolder(binding)
    }

    override fun bindViewHolder(
        model: SearchMode.ActionIcon,
        viewHolder: ActionIconViewHolder,
        payloads: List<DelegateAdapterItem.Payload>
    ) = viewHolder.onBind(model)
}
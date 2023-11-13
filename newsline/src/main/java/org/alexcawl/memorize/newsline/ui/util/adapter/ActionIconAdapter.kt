package org.alexcawl.memorize.newsline.ui.util.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.memorize.newsline.databinding.LayoutActionButtonBinding
import org.alexcawl.memorize.newsline.domain.SearchMode
import org.alexcawl.memorize.ui.delegates.DelegateAdapter
import org.alexcawl.memorize.ui.delegates.DelegateViewHolder

object ActionIconAdapter : DelegateAdapter<SearchMode.ActionIcon, ActionIconAdapter.ActionIconViewHolder>(
    SearchMode.ActionIcon::class.java
) {
    class ActionIconViewHolder(
        binding: LayoutActionButtonBinding
    ) : DelegateViewHolder<SearchMode.ActionIcon, LayoutActionButtonBinding>(binding) {
        override fun onBind(model: SearchMode.ActionIcon) {
            // TODO
        }
    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutActionButtonBinding.inflate(inflater, parent, false)
        return ActionIconViewHolder(binding)
    }

    override fun bindViewHolder(model: SearchMode.ActionIcon, viewHolder: ActionIconViewHolder) = viewHolder.onBind(model)
}
package org.alexcawl.memorize.newsline.ui.util.diff

import androidx.recyclerview.widget.DiffUtil
import org.alexcawl.memorize.newsline.domain.Filter

object FilterDifference : DiffUtil.ItemCallback<Filter>() {
    override fun areItemsTheSame(oldItem: Filter, newItem: Filter): Boolean =
        oldItem::class == newItem::class && oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Filter, newItem: Filter): Boolean =
        oldItem.content == newItem.content
}
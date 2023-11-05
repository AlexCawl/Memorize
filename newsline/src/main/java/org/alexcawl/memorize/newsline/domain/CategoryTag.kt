package org.alexcawl.memorize.newsline.domain

import org.alexcawl.memorize.network.dto.Category
import org.alexcawl.memorize.ui.DelegateAdapterItem

data class CategoryTag(
    val category: Category,
    val description: String
) : DelegateAdapterItem {
    override val id: Any
        get() = category
    override val content: Any
        get() = description
}

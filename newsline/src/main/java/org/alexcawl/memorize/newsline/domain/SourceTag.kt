package org.alexcawl.memorize.newsline.domain

import org.alexcawl.memorize.ui.DelegateAdapterItem

data class SourceTag(
    val sourceId: String,
    val description: String
) : DelegateAdapterItem {
    override val id: Any
        get() = sourceId
    override val content: Any
        get() = description
}

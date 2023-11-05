package org.alexcawl.memorize.newsline.domain

import org.alexcawl.memorize.ui.DelegateAdapterItem

data class ActionTag(
    val resId: Int,
    val onAction: () -> Unit = {}
) : DelegateAdapterItem {
    override val id: Any
        get() = resId
    override val content: Any
        get() = resId
}
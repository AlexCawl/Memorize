package org.alexcawl.memorize.newsline.domain

import org.alexcawl.memorize.ui.DAdapterItem
import java.util.UUID

data class Article(
    val newsId: UUID,
    val title: String,
    val url: String,
    val source: String,
    val urlToImage: String?,
    val publishedAt: String,
    val author: String?,
    val newsContent: String?,
    val description: String?
) : DAdapterItem {
    override val diffId: Any
        get() = newsId

    override val diffContent: Any
        get() = title
}
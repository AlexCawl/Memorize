package org.alexcawl.memorize.common

import java.util.UUID

data class ArticleModel(
    val newsId: UUID,
    val title: String,
    val url: String,
    val source: String,
    val publishedAt: String,
    val urlToImage: String?,
    val author: String?,
    val newsContent: String?,
    val description: String?
)
package org.alexcawl.memorize.newsline.domain

import java.util.UUID

data class Article(
    val id: UUID,
    val title: String,
    val url: String,
    val source: String,
    val urlToImage: String?,
    val publishedAt: String,
    val author: String?,
    val content: String?,
    val description: String?
)
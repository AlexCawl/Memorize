package org.alexcawl.memorize.network.datasource

import org.alexcawl.memorize.network.dto.Category
import org.alexcawl.memorize.network.dto.Country
import org.alexcawl.memorize.network.dto.article.ArticleResponseDTO

interface INewsArticleDataSource {
    suspend fun getTopHeadlines(
        query: String,
        country: Country? = null,
        category: Category? = null
    ): ArticleResponseDTO

    suspend fun getTopHeadlines(country: Country): ArticleResponseDTO

    suspend fun getTopHeadlines(category: Category): ArticleResponseDTO
}

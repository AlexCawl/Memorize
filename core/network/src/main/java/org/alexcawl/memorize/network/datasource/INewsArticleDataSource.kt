package org.alexcawl.memorize.network.datasource

import org.alexcawl.memorize.common.model.CategoryModel
import org.alexcawl.memorize.common.model.CountryModel
import org.alexcawl.memorize.network.dto.article.ArticleResponseDTO

interface INewsArticleDataSource {
    suspend fun getTopHeadlines(
        query: String,
        country: CountryModel? = null,
        category: CategoryModel? = null
    ): ArticleResponseDTO

    suspend fun getTopHeadlines(country: CountryModel): ArticleResponseDTO

    suspend fun getTopHeadlines(category: CategoryModel): ArticleResponseDTO
}

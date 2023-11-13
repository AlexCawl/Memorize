package org.alexcawl.memorize.network.datasource

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import org.alexcawl.memorize.network.NetworkConfiguration
import org.alexcawl.memorize.common.CategoryModel
import org.alexcawl.memorize.common.CountryModel
import org.alexcawl.memorize.network.dto.article.ArticleResponseDTO
import javax.inject.Inject

class NewsArticleDataSource @Inject constructor(
    private val client: HttpClient
) : INewsArticleDataSource {
    private companion object {
        const val COUNTRY: String = "country"
        const val CATEGORY: String = "category"
    }

    override suspend fun getTopHeadlines(
        query: String, country: CountryModel?, category: CategoryModel?
    ): ArticleResponseDTO = client.get {
        header(NetworkConfiguration.API_HEADER_NAME, NetworkConfiguration.API_HEADER_VALUE)
        url(NetworkConfiguration.TOP_HEADLINES_URL)
        parameter("q", query)
        country?.let { parameter(COUNTRY, country.toString().lowercase()) }
        category?.let { parameter(CATEGORY, category.toString().lowercase()) }
    }

    override suspend fun getTopHeadlines(country: CountryModel): ArticleResponseDTO {
        TODO("Not yet implemented")
    }

    override suspend fun getTopHeadlines(category: CategoryModel): ArticleResponseDTO {
        TODO("Not yet implemented")
    }
}
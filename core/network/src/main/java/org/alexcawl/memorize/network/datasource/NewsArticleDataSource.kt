package org.alexcawl.memorize.network.datasource

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import org.alexcawl.memorize.network.NetworkConfiguration
import org.alexcawl.memorize.network.dto.Category
import org.alexcawl.memorize.network.dto.Country
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
        query: String, country: Country?, category: Category?
    ): ArticleResponseDTO = client.get {
        header(NetworkConfiguration.API_HEADER_NAME, NetworkConfiguration.API_HEADER_VALUE)
        url(NetworkConfiguration.TOP_HEADLINES_URL)
        parameter("q", query)
        country?.let { parameter(COUNTRY, country.toString().lowercase()) }
        category?.let { parameter(CATEGORY, category.toString().lowercase()) }
    }

    override suspend fun getTopHeadlines(country: Country): ArticleResponseDTO {
        TODO("Not yet implemented")
    }

    override suspend fun getTopHeadlines(category: Category): ArticleResponseDTO {
        TODO("Not yet implemented")
    }
}
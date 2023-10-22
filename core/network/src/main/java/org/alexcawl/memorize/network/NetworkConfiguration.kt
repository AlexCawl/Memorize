package org.alexcawl.memorize.network

object NetworkConfiguration {
    const val API_HEADER_NAME: String = "x-api-key"
    const val API_HEADER_VALUE: String = "acb461fc312f467092249573a798b455"

    private const val BASE_URL: String = "https://newsapi.org"
    const val TOP_HEADLINES_URL: String = "$BASE_URL/v2/top-headlines"
}
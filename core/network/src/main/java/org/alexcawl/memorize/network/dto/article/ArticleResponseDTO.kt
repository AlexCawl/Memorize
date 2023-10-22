package org.alexcawl.memorize.network.dto.article

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ArticleResponseDTO(
    @SerialName("articles") val articles: List<ArticleDTO>,
    @SerialName("status") val status: String,
    @SerialName("totalResults") val totalResults: Int
)
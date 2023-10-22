package org.alexcawl.memorize.network.dto.source

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.alexcawl.memorize.network.dto.article.SourceBriefDTO


@Serializable
data class SourceResponseDTO(
    @SerialName("sources") val sources: List<SourceBriefDTO>,
    @SerialName("status") val status: String
)
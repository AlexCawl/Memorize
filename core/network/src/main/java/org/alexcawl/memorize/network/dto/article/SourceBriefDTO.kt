package org.alexcawl.memorize.network.dto.article

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourceBriefDTO(
    @SerialName("id") val id: String?,
    @SerialName("name") val name: String
)
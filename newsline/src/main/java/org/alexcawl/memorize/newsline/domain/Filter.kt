package org.alexcawl.memorize.newsline.domain

import org.alexcawl.memorize.network.dto.Category
import org.alexcawl.memorize.network.dto.Country

sealed interface Filter {
    val description: String

    data class QueryFilter(
        override val description: String
    ) : Filter

    data class CategoryFilter(
        val categoryId: Category,
        override val description: String = categoryId.name
    ) : Filter


    data class CountryFilter(
        val countryId: Country,
        override val description: String = countryId.name
    ) : Filter


    data class SourceFilter(
        val sourceId: String,
        override val description: String = sourceId
    ) : Filter
}
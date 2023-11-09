package org.alexcawl.memorize.newsline.domain

import org.alexcawl.memorize.ui.DAdapterItem

sealed interface Filter : DAdapterItem {
    val description: String

    data class Query(
        override val description: String
    ) : Filter {
        override val diffId: Any
            get() = description
        override val diffContent: Any
            get() = description
    }

    data class Category(
        val categoryId: org.alexcawl.memorize.network.dto.Category,
        override val description: String = categoryId.name
    ) : Filter {
        override val diffId: Any
            get() = categoryId
        override val diffContent: Any
            get() = description
    }


    data class Country(
        val countryId: org.alexcawl.memorize.network.dto.Country,
        override val description: String = countryId.name
    ) : Filter {
        override val diffId: Any
            get() = countryId
        override val diffContent: Any
            get() = description
    }


    data class Source(
        val sourceId: String,
        override val description: String = sourceId
    ) : Filter {
        override val diffId: Any
            get() = sourceId
        override val diffContent: Any
            get() = description
    }
}
package org.alexcawl.memorize.newsline.domain

import org.alexcawl.memorize.common.CategoryModel
import org.alexcawl.memorize.common.CountryModel
import org.alexcawl.memorize.ui.DelegateAdapterItem

sealed interface Filter : DelegateAdapterItem {
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
        val categoryId: CategoryModel,
        override val description: String = categoryId.name
    ) : Filter {
        override val diffId: Any
            get() = categoryId
        override val diffContent: Any
            get() = description
    }


    data class Country(
        val countryId: CountryModel,
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
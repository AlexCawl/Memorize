package org.alexcawl.memorize.newsline.domain

import org.alexcawl.memorize.common.CategoryModel
import org.alexcawl.memorize.common.CountryModel

sealed interface Filter {
    val id: Int
    val content: String

    data class Query(
        override val content: String
    ) : Filter {
        override val id: Int
            get() = content.hashCode()
    }

    data class Category(
        val category: CategoryModel,
        override val content: String = category.name
    ) : Filter {
        override val id: Int
            get() = category.hashCode()

    }


    data class Country(
        val country: CountryModel,
        override val content: String = country.name
    ) : Filter {
        override val id: Int
            get() = country.hashCode()
    }


    data class Source(
        val source: String,
        override val content: String = source
    ) : Filter {
        override val id: Int
            get() = source.hashCode()
    }
}
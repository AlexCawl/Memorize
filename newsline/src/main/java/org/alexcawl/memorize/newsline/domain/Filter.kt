package org.alexcawl.memorize.newsline.domain

sealed interface Filter {
    val title: String

    data class Country(override val title: String) : Filter

    data class Category(override val title: String) : Filter

    data class Source(override val title: String) : Filter
}
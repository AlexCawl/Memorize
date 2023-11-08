package org.alexcawl.memorize.newsline.ui.search

import org.alexcawl.memorize.newsline.domain.Filter
import org.alexcawl.memorize.newsline.domain.SearchMode

sealed interface TopNewsSearchMode : SearchMode {
    data object EmptyTopNewsSearchMode : TopNewsSearchMode {
        override val iconAction: SearchMode.IconAction
            get() = SearchMode.IconAction(SearchMode.IconType.ADD)

        override fun iterator(): Iterator<Filter> = listOf<Filter>().iterator()
    }

    data class TagTopNewsSearchMode(
        val query: Filter.QueryFilter,
        val country: Filter.CountryFilter?,
        val category: Filter.CategoryFilter?
    ) : TopNewsSearchMode {
        override val iconAction: SearchMode.IconAction
            get() = when {
                country == null && category == null -> SearchMode.IconType.ADD
                country == null || category == null -> SearchMode.IconType.CHANGE
                else -> SearchMode.IconType.CONFIGURE
            }.let { SearchMode.IconAction(it) }

        override fun iterator(): Iterator<Filter> {
            return mutableListOf<Filter>(query).apply {
                country?.let { add(country) }
                category?.let { add(category) }
                add(iconAction)
            }.toList().iterator()
        }
    }

    data class SourceTopNewsSearchMode(
        val query: Filter.QueryFilter,
        val sources: List<Filter.SourceFilter>
    ) : TopNewsSearchMode {
        override val iconAction: SearchMode.IconAction
            get() = when {
                sources.isEmpty() -> SearchMode.IconType.ADD
                else -> SearchMode.IconType.CHANGE
            }.let { SearchMode.IconAction(it) }

        override fun iterator(): Iterator<Filter> {
            return mutableListOf<Filter>(query).apply {
                addAll(sources)
                add(iconAction)
            }.toList().iterator()
        }
    }
}
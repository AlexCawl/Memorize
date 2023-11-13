package org.alexcawl.memorize.newsline.ui.search

import org.alexcawl.memorize.newsline.domain.Filter
import org.alexcawl.memorize.newsline.domain.SearchMode

sealed interface NewsSearchMode : SearchMode {
    data object EmptyNewsSearchMode : NewsSearchMode {
        override val actionIcon: SearchMode.ActionIcon
            get() = SearchMode.ActionIcon(SearchMode.IconType.ADD)

        override fun iterator(): Iterator<Filter> = listOf<Filter>().iterator()
    }

    data class TagNewsSearchMode(
        val query: Filter.Query,
        val country: Filter.Country?,
        val category: Filter.Category?
    ) : NewsSearchMode {
        override val actionIcon: SearchMode.ActionIcon
            get() = when {
                country == null && category == null -> SearchMode.IconType.ADD
                country == null || category == null -> SearchMode.IconType.CHANGE
                else -> SearchMode.IconType.CONFIGURE
            }.let { SearchMode.ActionIcon(it) }

        override fun iterator(): Iterator<Filter> {
            return mutableListOf<Filter>(query).apply {
                country?.let { add(country) }
                category?.let { add(category) }
                add(actionIcon)
            }.toList().iterator()
        }
    }

    data class SourceNewsSearchMode(
        val query: Filter.Query,
        val sources: List<Filter.Source>
    ) : NewsSearchMode {
        override val actionIcon: SearchMode.ActionIcon
            get() = when {
                sources.isEmpty() -> SearchMode.IconType.ADD
                else -> SearchMode.IconType.CHANGE
            }.let { SearchMode.ActionIcon(it) }

        override fun iterator(): Iterator<Filter> {
            return mutableListOf<Filter>(query).apply {
                addAll(sources)
                add(actionIcon)
            }.toList().iterator()
        }
    }
}
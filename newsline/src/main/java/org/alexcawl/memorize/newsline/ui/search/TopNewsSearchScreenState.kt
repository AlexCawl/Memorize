package org.alexcawl.memorize.newsline.ui.search

import org.alexcawl.memorize.newsline.domain.Article

sealed interface TopNewsSearchScreenState {
    val search: TopNewsSearchMode
    val articles: List<Article>

    data object Initial : TopNewsSearchScreenState {
        override val search: TopNewsSearchMode
            get() = TopNewsSearchMode.EmptyTopNewsSearchMode

        override val articles: List<Article>
            get() = listOf()
    }

    data class Loading(override val search: TopNewsSearchMode) : TopNewsSearchScreenState {
        override val articles: List<Article>
            get() = listOf()

    }

    data class Successful(
        override val search: TopNewsSearchMode,
        override val articles: List<Article>
    ) : TopNewsSearchScreenState

    data class Fail(
        override val search: TopNewsSearchMode,
        val message: String
    ) : TopNewsSearchScreenState {
        override val articles: List<Article>
            get() = listOf()
    }
}
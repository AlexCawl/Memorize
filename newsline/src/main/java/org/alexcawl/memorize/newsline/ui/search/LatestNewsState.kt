package org.alexcawl.memorize.newsline.ui.search

import org.alexcawl.memorize.newsline.domain.Article

sealed interface LatestNewsState {
    val search: NewsSearchMode
    val articles: List<Article>

    data object Initial : LatestNewsState {
        override val search: NewsSearchMode
            get() = NewsSearchMode.EmptyNewsSearchMode

        override val articles: List<Article>
            get() = listOf()
    }

    data class Loading(override val search: NewsSearchMode) : LatestNewsState {
        override val articles: List<Article>
            get() = listOf()

    }

    data class Successful(
        override val search: NewsSearchMode,
        override val articles: List<Article>
    ) : LatestNewsState

    data class Fail(
        override val search: NewsSearchMode,
        val message: String
    ) : LatestNewsState {
        override val articles: List<Article>
            get() = listOf()
    }
}
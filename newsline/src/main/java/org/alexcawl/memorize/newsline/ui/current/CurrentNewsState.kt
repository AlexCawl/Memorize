package org.alexcawl.memorize.newsline.ui.current

import org.alexcawl.memorize.newsline.domain.Article
import org.alexcawl.memorize.newsline.ui.search.TopNewsSearchMode

sealed interface CurrentNewsState {
    val search: TopNewsSearchMode
    val articles: List<Article>

    data object Initial : CurrentNewsState {
        override val search: TopNewsSearchMode
            get() = TopNewsSearchMode.EmptyTopNewsSearchMode

        override val articles: List<Article>
            get() = listOf()
    }

    data class Successful(
        override val search: TopNewsSearchMode,
        override val articles: List<Article>
    ) : CurrentNewsState

    data class Fail(
        override val search: TopNewsSearchMode,
        val message: String
    ) : CurrentNewsState {
        override val articles: List<Article>
            get() = listOf()
    }
}
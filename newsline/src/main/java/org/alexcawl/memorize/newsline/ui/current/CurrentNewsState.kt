package org.alexcawl.memorize.newsline.ui.current

import org.alexcawl.memorize.common.ArticleModel
import org.alexcawl.memorize.newsline.domain.Article
import org.alexcawl.memorize.newsline.ui.search.NewsSearchMode

sealed interface CurrentNewsState {
    val search: NewsSearchMode
    val articles: List<ArticleModel>

    data object Initial : CurrentNewsState {
        override val search: NewsSearchMode
            get() = NewsSearchMode.EmptyNewsSearchMode

        override val articles: List<ArticleModel>
            get() = listOf()
    }

    data class Successful(
        override val search: NewsSearchMode,
        override val articles: List<ArticleModel>
    ) : CurrentNewsState

    data class Fail(
        override val search: NewsSearchMode,
        val message: String
    ) : CurrentNewsState {
        override val articles: List<ArticleModel>
            get() = listOf()
    }
}
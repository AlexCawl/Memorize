package org.alexcawl.memorize.newsline.ui.current

import org.alexcawl.memorize.newsline.domain.Article
import org.alexcawl.memorize.newsline.domain.Filter

sealed interface CurrentNewsState {
    val filters: List<Filter>
    val articles: List<Article>

    data object Initial : CurrentNewsState {
        override val filters: List<Filter>
            get() = listOf()
        override val articles: List<Article>
            get() = listOf()
    }

    data class Successful(
        override val filters: List<Filter>,
        override val articles: List<Article>
    ) : CurrentNewsState

    data class Fail(val message: String) : CurrentNewsState {
        override val filters: List<Filter>
            get() = listOf()
        override val articles: List<Article>
            get() = listOf()
    }
}
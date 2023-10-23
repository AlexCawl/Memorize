package org.alexcawl.memorize.newsline.ui

import org.alexcawl.memorize.newsline.domain.Article
import org.alexcawl.memorize.newsline.domain.Filter

sealed interface NewsState {
    val filters: List<Filter>
    val articles: List<Article>

    data object Initial : NewsState {
        override val filters: List<Filter>
            get() = listOf()
        override val articles: List<Article>
            get() = listOf()
    }

    data class Successful(
        override val filters: List<Filter>,
        override val articles: List<Article>
    ) : NewsState

    data class Fail(val message: String) : NewsState {
        override val filters: List<Filter>
            get() = listOf()
        override val articles: List<Article>
            get() = listOf()
    }
}
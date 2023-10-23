package org.alexcawl.memorize.newsline.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.alexcawl.memorize.network.Ktor
import org.alexcawl.memorize.network.datasource.INewsArticleDataSource
import org.alexcawl.memorize.network.datasource.NewsArticleDataSource
import org.alexcawl.memorize.network.dto.article.ArticleResponseDTO
import org.alexcawl.memorize.newsline.domain.Article
import java.util.UUID

class CurrentNewsViewModel : ViewModel() {
    private val _state: MutableStateFlow<NewsState> = MutableStateFlow(NewsState.Initial)
    val state: StateFlow<NewsState> get() = _state.asStateFlow()

    private val source: INewsArticleDataSource = NewsArticleDataSource(Ktor.client)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val articles: ArticleResponseDTO = source.getTopHeadlines("Israel")
            _state.emit(
                NewsState.Successful(
                    listOf(),
                    articles.articles.map {
                        Article(
                            UUID.randomUUID(),
                            it.title,
                            it.url,
                            it.source.name,
                            it.urlToImage,
                            it.publishedAt,
                            it.author,
                            it.content,
                            it.description
                        )
                    }
                )
            )
        }
    }
}
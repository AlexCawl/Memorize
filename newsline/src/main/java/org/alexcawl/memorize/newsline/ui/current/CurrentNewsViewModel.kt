package org.alexcawl.memorize.newsline.ui.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.alexcawl.memorize.network.datasource.INewsArticleDataSource
import org.alexcawl.memorize.network.dto.article.ArticleResponseDTO
import org.alexcawl.memorize.newsline.domain.Article
import java.util.UUID
import javax.inject.Inject

class CurrentNewsViewModel @Inject constructor(
    private val source: INewsArticleDataSource
) : ViewModel() {
    private val _state: MutableStateFlow<CurrentNewsState> = MutableStateFlow(CurrentNewsState.Initial)
    val state: StateFlow<CurrentNewsState> get() = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val articles: ArticleResponseDTO = source.getTopHeadlines("Israel")
            _state.emit(
                CurrentNewsState.Successful(
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
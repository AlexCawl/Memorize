package org.alexcawl.memorize.newsline.ui.search

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.alexcawl.memorize.common.ArticleModel
import org.alexcawl.memorize.network.datasource.INewsArticleDataSource
import org.alexcawl.memorize.network.dto.article.ArticleResponseDTO
import org.alexcawl.memorize.newsline.domain.Filter
import org.alexcawl.memorize.ui.StateHolder
import java.util.UUID
import javax.inject.Inject

class LatestNewsViewModel @Inject constructor(
    private val source: INewsArticleDataSource
) : StateHolder<LatestNewsState, LatestNewsAction>() {
    private val _state: MutableStateFlow<LatestNewsState> =
        MutableStateFlow(LatestNewsState.Initial)
    override val state: StateFlow<LatestNewsState> = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val articles: ArticleResponseDTO = source.getTopHeadlines("Israel")
            _state.emit(
                LatestNewsState.Successful(
                    NewsSearchMode.TagNewsSearchMode(Filter.Query("Israel"), null, null),
                    articles.articles.map {
                        ArticleModel(
                            UUID.randomUUID(),
                            it.title,
                            it.url,
                            it.source.name,
                            it.publishedAt,
                            it.urlToImage,
                            it.author,
                            it.content,
                            it.description
                        )
                    }
                )
            )
        }
    }

    override fun handle(action: LatestNewsAction) {
        when (action) {
            is LatestNewsAction.ChangeSearchMode -> {
                viewModelScope.launch {
                    _state.emit(LatestNewsState.Loading(action.searchMode))
                    fetchArticles()
                }
            }

            is LatestNewsAction.UpdateNews -> {
                viewModelScope.launch {
                    fetchArticles()
                }
            }
        }
    }

    private suspend fun fetchArticles() {
        val mode: NewsSearchMode = state.value.search
        // TODO выход в сеть
    }
}
package org.alexcawl.memorize.newsline.ui.search

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.alexcawl.memorize.network.datasource.INewsArticleDataSource
import org.alexcawl.memorize.ui.StateHolder
import javax.inject.Inject

class LatestNewsViewModel @Inject constructor(
    private val source: INewsArticleDataSource
) : StateHolder<LatestNewsState, LatestNewsAction>() {
    private val _state: MutableStateFlow<LatestNewsState> =
        MutableStateFlow(LatestNewsState.Initial)
    override val state: StateFlow<LatestNewsState> = _state.asStateFlow()

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
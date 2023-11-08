package org.alexcawl.memorize.newsline.ui.search

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.alexcawl.memorize.network.datasource.INewsArticleDataSource
import org.alexcawl.memorize.ui.StateHolder
import javax.inject.Inject

class SearchNewsViewModel @Inject constructor(
    private val source: INewsArticleDataSource
) : StateHolder<TopNewsSearchScreenState, TopNewsSearchAction>() {
    private val _state: MutableStateFlow<TopNewsSearchScreenState> =
        MutableStateFlow(TopNewsSearchScreenState.Initial)
    override val state: StateFlow<TopNewsSearchScreenState> = _state.asStateFlow()

    override fun handle(action: TopNewsSearchAction) {
        when (action) {
            is TopNewsSearchAction.ChangeSearchMode -> {
                viewModelScope.launch {
                    _state.emit(TopNewsSearchScreenState.Loading(action.searchMode))
                    fetchArticles()
                }
            }
            is TopNewsSearchAction.UpdateNews -> {
                viewModelScope.launch {
                    fetchArticles()
                }
            }
        }
    }

    private suspend fun fetchArticles() {
        val mode: TopNewsSearchMode = state.value.search
        // TODO выход в сеть
    }
}
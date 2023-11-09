package org.alexcawl.memorize.newsline.ui.search

sealed interface LatestNewsAction {
    data class ChangeSearchMode(val searchMode: NewsSearchMode) : LatestNewsAction

    data object UpdateNews : LatestNewsAction
}
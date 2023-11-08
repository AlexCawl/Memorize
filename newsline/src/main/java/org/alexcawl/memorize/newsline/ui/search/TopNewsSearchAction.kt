package org.alexcawl.memorize.newsline.ui.search

sealed interface TopNewsSearchAction {
    data class ChangeSearchMode(val searchMode: TopNewsSearchMode) : TopNewsSearchAction

    object UpdateNews : TopNewsSearchAction
}
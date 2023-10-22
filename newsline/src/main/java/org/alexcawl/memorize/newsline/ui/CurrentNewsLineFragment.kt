package org.alexcawl.memorize.newsline.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import org.alexcawl.memorize.network.Ktor
import org.alexcawl.memorize.network.datasource.INewsArticleDataSource
import org.alexcawl.memorize.network.datasource.NewsArticleDataSource

class CurrentNewsLineFragment : BaseNewsLineFragment() {
    private val source: INewsArticleDataSource = NewsArticleDataSource(Ktor.client)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                source.getTopHeadlines("Israel")
            }
        }
    }
}
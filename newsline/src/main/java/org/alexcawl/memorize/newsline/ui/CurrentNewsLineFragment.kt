package org.alexcawl.memorize.newsline.ui

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import org.alexcawl.memorize.newsline.R

class CurrentNewsLineFragment : BaseNewsLineFragment() {
    private val model: CurrentNewsViewModel by viewModels { factory }

    override fun setupView() {
        title.text = "Israel"
    }

    override fun setupState() {
        val articleAdapter = ArticleAdapter()
        with(news) {
            layoutManager = LinearLayoutManager(context)
            adapter = articleAdapter
            addItemDecoration(
                MarginItemDecorator(resources.getDimensionPixelSize(R.dimen.articles_margin_between))
            )
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                model.state.collect { state ->
                    when (state) {
                        is NewsState.Initial -> {
                            articleAdapter.submitList(listOf())
                        }

                        is NewsState.Successful -> {
                            articleAdapter.submitList(state.articles)
                        }

                        is NewsState.Fail -> TODO()
                    }
                }
            }
        }
    }
}
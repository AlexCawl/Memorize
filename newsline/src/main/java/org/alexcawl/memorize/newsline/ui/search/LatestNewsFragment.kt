package org.alexcawl.memorize.newsline.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.alexcawl.memorize.common.ArticleModel
import org.alexcawl.memorize.newsline.DaggerNewsLineComponent
import org.alexcawl.memorize.newsline.R
import org.alexcawl.memorize.newsline.databinding.FragmentSearchNewsBinding
import org.alexcawl.memorize.newsline.di.NewsLineDependenciesStore
import org.alexcawl.memorize.newsline.domain.Filter
import org.alexcawl.memorize.newsline.ui.util.MarginItemDecorator
import org.alexcawl.memorize.newsline.ui.util.adapter.ActionIconAdapter
import org.alexcawl.memorize.newsline.ui.util.adapter.ArticleAdapter
import org.alexcawl.memorize.newsline.ui.util.adapter.CategoryAdapter
import org.alexcawl.memorize.newsline.ui.util.adapter.CountryAdapter
import org.alexcawl.memorize.newsline.ui.util.adapter.QueryAdapter
import org.alexcawl.memorize.newsline.ui.util.diff.ArticleDifference
import org.alexcawl.memorize.newsline.ui.util.diff.FilterDifference
import org.alexcawl.memorize.ui.StateFragment
import org.alexcawl.memorize.ui.delegates.CompositeAdapter
import javax.inject.Inject

class LatestNewsFragment : StateFragment() {
    /*
    * Fragment binding
    * */
    private var _binding: FragmentSearchNewsBinding? = null
    private val binding: FragmentSearchNewsBinding get() = _binding!!

    /*
    * Dagger DI
    * */
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val model: LatestNewsViewModel by viewModels { factory }

    /*
    * Fragment variables
    * */
    private lateinit var newsAdapter: CompositeAdapter<ArticleModel>
    private lateinit var tagsAdapter: CompositeAdapter<Filter>

    override fun onAttach(context: Context) {
        DaggerNewsLineComponent.builder()
            .dependencies(NewsLineDependenciesStore.dependencies)
            .build()
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupBindings() {
        /*
        * Setup news adapter
        * */
        newsAdapter = CompositeAdapter.Builder(ArticleDifference)
            .add(ArticleAdapter)
            .build()
        with(binding.news) {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
            addItemDecoration(
                MarginItemDecorator(resources.getDimensionPixelSize(R.dimen.articles_margin_between))
            )
        }

        /*
        * Setup tags adapter
        * */
        tagsAdapter = CompositeAdapter.Builder(FilterDifference)
            .add(QueryAdapter)
            .add(CountryAdapter)
            .add(CategoryAdapter)
            .add(ActionIconAdapter)
            .build()
        with(binding.tags) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = tagsAdapter
        }
    }

    override fun setupState() {
        lifecycleScope.launch(Dispatchers.Main) {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                model.state.collect { state ->
                    newsAdapter.submitList(state.articles)
                    tagsAdapter.submitList(state.search.toList())
                }
            }
        }
    }
}
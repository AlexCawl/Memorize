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
import org.alexcawl.memorize.newsline.DaggerNewsLineComponent
import org.alexcawl.memorize.newsline.R
import org.alexcawl.memorize.newsline.databinding.FragmentSearchNewsBinding
import org.alexcawl.memorize.newsline.di.NewsLineDependenciesStore
import org.alexcawl.memorize.newsline.ui.util.ActionIconAdapter
import org.alexcawl.memorize.newsline.ui.util.ArticleAdapter
import org.alexcawl.memorize.newsline.ui.util.CategoryAdapter
import org.alexcawl.memorize.newsline.ui.util.CountryAdapter
import org.alexcawl.memorize.newsline.ui.util.MarginItemDecorator
import org.alexcawl.memorize.newsline.ui.util.QueryAdapter
import org.alexcawl.memorize.ui.CompositeAdapter
import org.alexcawl.memorize.ui.StateFragment
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
    private lateinit var newsAdapter: CompositeAdapter
    private lateinit var tagsAdapter: CompositeAdapter

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
        newsAdapter = CompositeAdapter.Builder()
            .add(ArticleAdapter())
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
        tagsAdapter = CompositeAdapter.Builder()
            .add(QueryAdapter())
            .add(CategoryAdapter())
            .add(CountryAdapter())
            .add(ActionIconAdapter())
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
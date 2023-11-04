package org.alexcawl.memorize.newsline.ui.current

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
import org.alexcawl.memorize.newsline.databinding.FragmentCurrentNewsBinding
import org.alexcawl.memorize.newsline.di.NewsLineDependenciesStore
import org.alexcawl.memorize.newsline.ui.ArticleDelegateAdapter
import org.alexcawl.memorize.newsline.ui.MarginItemDecorator
import org.alexcawl.memorize.newsline.ui.NewsState
import org.alexcawl.memorize.ui.CompositeAdapter
import org.alexcawl.memorize.ui.StatefulFragment
import javax.inject.Inject

class CurrentNewsFragment : StatefulFragment() {
    /*
    * Fragment binding
    * */
    private var _binding: FragmentCurrentNewsBinding? = null
    private val binding: FragmentCurrentNewsBinding get() = _binding!!

    /*
    * Dagger DI
    * */
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val model: CurrentNewsViewModel by viewModels { factory }

    /*
    * Fragment variables
    * */
    private var _newsAdapter: CompositeAdapter? = null
    private val newsAdapter: CompositeAdapter get() = _newsAdapter!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerNewsLineComponent.builder().dependencies(NewsLineDependenciesStore.dependencies)
            .build().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupBindings() {
        /*
        * Setup news adapter
        * */
        _newsAdapter = CompositeAdapter.Builder().add(ArticleDelegateAdapter()).build()
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
        // TODO
    }

    override fun setupState() {
        /*
        * Setup news collecting
        * */
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                model.state.collect { state ->
                    when (state) {
                        is NewsState.Initial -> newsAdapter.submitList(listOf())
                        is NewsState.Successful -> newsAdapter.submitList(state.articles)
                        is NewsState.Fail -> TODO()
                    }
                }
            }
        }

        /*
        * Setup tags collecting
        * */
        // TODO
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _newsAdapter = null
    }
}
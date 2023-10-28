package org.alexcawl.memorize.newsline.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import org.alexcawl.memorize.newsline.DaggerNewsLineComponent
import org.alexcawl.memorize.newsline.R
import org.alexcawl.memorize.newsline.databinding.FragmentCurrentNewsBinding
import org.alexcawl.memorize.newsline.di.NewsLineDependenciesStore
import org.alexcawl.memorize.ui.StatefulFragment
import javax.inject.Inject

class CurrentNewsFragment : StatefulFragment() {
    private var _binding: FragmentCurrentNewsBinding? = null
    private val binding get() = _binding!!

    private val title: TextView by lazy { binding.title }
    private val iconProfile: ImageView by lazy { binding.profileIcon }
    private val news: RecyclerView by lazy { binding.news }
    private val tags: RecyclerView by lazy { binding.newsTagsSelected }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val model: CurrentNewsViewModel by viewModels { factory }

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
                        is NewsState.Initial -> articleAdapter.submitList(listOf())
                        is NewsState.Successful -> articleAdapter.submitList(state.articles)
                        is NewsState.Fail -> TODO()
                    }
                }
            }
        }
    }
}
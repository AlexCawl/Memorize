package org.alexcawl.memorize.newsline.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import org.alexcawl.memorize.newsline.DaggerNewsLineComponent
import org.alexcawl.memorize.newsline.databinding.FragmentSearchNewsBinding
import org.alexcawl.memorize.newsline.di.NewsLineDependenciesStore
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

    }

    override fun setupState() {

    }
}
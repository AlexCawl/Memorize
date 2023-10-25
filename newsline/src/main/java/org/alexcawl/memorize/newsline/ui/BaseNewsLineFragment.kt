package org.alexcawl.memorize.newsline.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.alexcawl.memorize.newsline.DaggerNewsLineComponent
import org.alexcawl.memorize.newsline.NewsLineDependenciesStore
import org.alexcawl.memorize.newsline.databinding.FragmentNewsLineBinding
import javax.inject.Inject

abstract class BaseNewsLineFragment : Fragment() {
    private var _binding: FragmentNewsLineBinding? = null
    private val binding get() = _binding!!

    protected val title: TextView by lazy { binding.title }
    protected val iconProfile: ImageView by lazy { binding.profileIcon }
    protected val bottomBar: BottomNavigationView by lazy { binding.bottomNavigation }
    protected val news: RecyclerView by lazy { binding.news }
    protected val addTagButton: Button by lazy { binding.addTag }
    protected val tags: RecyclerView by lazy { binding.newsTagsSelected }

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerNewsLineComponent.builder()
            .dependencies(NewsLineDependenciesStore.dependencies)
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsLineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupView()
        setupState()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun setupView()

    abstract fun setupState()
}
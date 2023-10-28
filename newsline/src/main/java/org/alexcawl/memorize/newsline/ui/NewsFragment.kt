package org.alexcawl.memorize.newsline.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.alexcawl.memorize.newsline.R
import org.alexcawl.memorize.newsline.databinding.FragmentNewsBinding
import org.alexcawl.memorize.ui.StatefulFragment
import org.alexcawl.memorize.ui.replace

class NewsFragment : StatefulFragment() {
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private val navigation: BottomNavigationView by lazy { binding.newsNavigationView }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupBindings() {
        navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.current_news -> parentFragmentManager.beginTransaction()
                    .replace(R.id.news_navigation_container, CurrentNewsFragment::class.java)
                    .commit()

                R.id.saved_news -> parentFragmentManager.beginTransaction()
                    .replace(R.id.news_navigation_container, SavedNewsFragment::class.java).commit()

                R.id.search_news -> parentFragmentManager.beginTransaction()
                    .replace(R.id.news_navigation_container, SearchNewsFragment::class.java)
                    .commit()

                else -> error("Operation with ${it.itemId} is illegal!")
            }
            return@setOnItemSelectedListener true
        }
    }

    override fun setupState() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
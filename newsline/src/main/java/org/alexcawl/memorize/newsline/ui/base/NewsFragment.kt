package org.alexcawl.memorize.newsline.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.alexcawl.memorize.newsline.R
import org.alexcawl.memorize.newsline.databinding.FragmentNewsBinding
import org.alexcawl.memorize.ui.StatefulFragment

class NewsFragment : StatefulFragment() {
    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupBindings() {
        val navigationHost =
            childFragmentManager.findFragmentById(R.id.news_navigation_container) as NavHostFragment
        val navigationController = navigationHost.navController
        val navigationView: BottomNavigationView = binding.newsNavigationView
        navigationView.setupWithNavController(navigationController)
    }

    override fun setupState() = Unit

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
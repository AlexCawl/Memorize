package org.alexcawl.memorize.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class StatefulFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBindings()
        setupState()
    }

    abstract fun setupBindings()

    abstract fun setupState()
}
package org.alexcawl.memorize.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class StateFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBindings()
        setupState()
    }

    /**
     * Called in Fragment.onViewCreated. Used to configure bindings and set up views before state collecting.
     * */
    abstract fun setupBindings()

    /**
     * Called in Fragment.onViewCreated. Called after setupBindings. Used to configure state collecting for screen.
     * */
    abstract fun setupState()
}
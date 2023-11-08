package org.alexcawl.memorize.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class StateHolder<S, A> : ViewModel() {
    abstract val state: StateFlow<S>

    abstract fun handle(action: A)
}
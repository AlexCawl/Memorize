package org.alexcawl.memorize.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class StateViewModel<S> : ViewModel() {
    abstract val state: StateFlow<S>

    abstract fun handle(action: Action)
}
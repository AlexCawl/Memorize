package org.alexcawl.memorize.ui.util

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

fun FragmentTransaction.replace(
    @IdRes containerViewId: Int,
    fragmentClass: Class<out Fragment>
): FragmentTransaction = this.replace(containerViewId, fragmentClass, null)
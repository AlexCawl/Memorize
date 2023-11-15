package org.alexcawl.memorize.common.util

interface OneWayMapper<F, T> {
    fun map(from: F): T
}
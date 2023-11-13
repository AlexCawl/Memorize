package org.alexcawl.memorize.common

interface OneWayMapper<F, T> {
    fun map(from: F): T
}
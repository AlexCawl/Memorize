package org.alexcawl.memorize.newsline

interface NewsLineDependenciesProvider {
    val dependencies: NewsLineDependencies

    companion object : NewsLineDependenciesProvider by NewsLineDependenciesStore
}
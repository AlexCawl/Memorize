package org.alexcawl.memorize.newsline.di

interface NewsLineDependenciesProvider {
    val dependencies: NewsLineDependencies

    companion object : NewsLineDependenciesProvider by NewsLineDependenciesStore
}
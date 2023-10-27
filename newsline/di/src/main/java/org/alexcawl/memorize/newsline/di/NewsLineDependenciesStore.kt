package org.alexcawl.memorize.newsline.di

import kotlin.properties.Delegates

object NewsLineDependenciesStore : NewsLineDependenciesProvider {
    override var dependencies: NewsLineDependencies by Delegates.notNull()
}
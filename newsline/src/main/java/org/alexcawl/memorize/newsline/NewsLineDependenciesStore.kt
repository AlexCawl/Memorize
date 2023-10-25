package org.alexcawl.memorize.newsline

import kotlin.properties.Delegates

object NewsLineDependenciesStore : NewsLineDependenciesProvider {
    override var dependencies: NewsLineDependencies by Delegates.notNull()
}
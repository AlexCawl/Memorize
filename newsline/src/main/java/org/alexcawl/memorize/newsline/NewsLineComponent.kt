package org.alexcawl.memorize.newsline

import dagger.Component
import org.alexcawl.memorize.newsline.di.NewsLineDependencies
import org.alexcawl.memorize.newsline.di.NewsLineScope
import org.alexcawl.memorize.newsline.ui.CurrentNewsFragment
import org.alexcawl.memorize.newsline.ui.NewsFragment
import org.alexcawl.memorize.newsline.ui.SavedNewsFragment
import org.alexcawl.memorize.newsline.ui.SearchNewsFragment

@Component(dependencies = [NewsLineDependencies::class], modules = [NewsLineModule::class])
@NewsLineScope
interface NewsLineComponent {
    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: NewsLineDependencies): Builder

        fun build(): NewsLineComponent
    }

    fun inject(fragment: NewsFragment)

    fun inject(fragment: CurrentNewsFragment)

    fun inject(fragment: SavedNewsFragment)

    fun inject(fragment: SearchNewsFragment)
}
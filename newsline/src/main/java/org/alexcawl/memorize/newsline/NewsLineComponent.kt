package org.alexcawl.memorize.newsline

import dagger.Component
import org.alexcawl.memorize.newsline.ui.BaseNewsLineFragment

@Component(dependencies = [NewsLineDependencies::class], modules = [NewsLineViewModelModule::class])
@NewsLineScope
interface NewsLineComponent {
    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: NewsLineDependencies): Builder

        fun build(): NewsLineComponent
    }

    fun inject(fragment: BaseNewsLineFragment)
}
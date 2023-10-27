package org.alexcawl.memorize

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import org.alexcawl.memorize.di.ViewModelModule
import org.alexcawl.memorize.network.NetworkModule
import org.alexcawl.memorize.network.datasource.INewsArticleDataSource
import org.alexcawl.memorize.newsline.di.NewsLineDependencies
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class, ViewModelModule::class, NetworkModule::class])
@Singleton
interface ApplicationComponent : NewsLineDependencies {
    override val context: Context
    override val newsArticleSource: INewsArticleDataSource

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder

        fun build(): ApplicationComponent
    }

    // TODO inject into services/receivers
}
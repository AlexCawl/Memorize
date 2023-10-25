package org.alexcawl.memorize

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import org.alexcawl.memorize.network.NetworkModule
import org.alexcawl.memorize.newsline.NewsLineDependencies
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface ApplicationComponent : NewsLineDependencies {
    override val context: Context

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder

        fun build(): ApplicationComponent
    }

    // TODO inject into services/receivers
}
package org.alexcawl.memorize

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import org.alexcawl.memorize.common.CommonModule
import org.alexcawl.memorize.di.ViewModelModule
import org.alexcawl.memorize.network.NetworkModule
import org.alexcawl.memorize.newsline.di.NewsLineDependencies
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class, NetworkModule::class, CommonModule::class])
interface ApplicationComponent : NewsLineDependencies {
    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder

        fun build(): ApplicationComponent
    }

    // here inject into services/receivers
}
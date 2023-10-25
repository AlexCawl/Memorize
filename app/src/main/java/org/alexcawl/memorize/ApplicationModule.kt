package org.alexcawl.memorize

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import coil.ImageLoader
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface ApplicationModule {
    companion object {
        @Provides
        @Singleton
        fun provideImageLoader(context: Context): ImageLoader = ImageLoader.Builder(context)
            .crossfade(true)
            .build()
    }

    @Binds
    @Singleton
    fun bindFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
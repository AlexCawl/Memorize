package org.alexcawl.memorize

import android.content.Context
import coil.ImageLoader
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
}
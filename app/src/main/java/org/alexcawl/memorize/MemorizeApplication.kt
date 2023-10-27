package org.alexcawl.memorize

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import org.alexcawl.memorize.newsline.di.NewsLineDependenciesStore

class MemorizeApplication : Application(), ImageLoaderFactory {
    private val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .context(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        NewsLineDependenciesStore.dependencies = applicationComponent
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this).crossfade(true).build()
    }
}
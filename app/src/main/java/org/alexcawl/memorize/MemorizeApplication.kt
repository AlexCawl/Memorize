package org.alexcawl.memorize

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory

class MemorizeApplication : Application(), ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .crossfade(true)
            .build()
    }
}
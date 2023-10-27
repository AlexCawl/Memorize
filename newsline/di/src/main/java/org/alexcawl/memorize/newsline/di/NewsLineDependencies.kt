package org.alexcawl.memorize.newsline.di

import android.content.Context
import org.alexcawl.memorize.network.datasource.INewsArticleDataSource

interface NewsLineDependencies {
    val context: Context
    val newsArticleSource: INewsArticleDataSource
}
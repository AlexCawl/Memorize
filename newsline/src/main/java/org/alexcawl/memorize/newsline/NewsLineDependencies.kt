package org.alexcawl.memorize.newsline

import android.content.Context
import org.alexcawl.memorize.network.datasource.INewsArticleDataSource

interface NewsLineDependencies {
    val context: Context
    val newsArticleSource: INewsArticleDataSource
}
package org.alexcawl.memorize.newsline.di

import android.content.Context
import org.alexcawl.memorize.common.resolver.ICategoryResolver
import org.alexcawl.memorize.common.resolver.ICountryResolver
import org.alexcawl.memorize.network.datasource.INewsArticleDataSource

interface NewsLineDependencies {
    val context: Context
    val newsArticleSource: INewsArticleDataSource
    val countryResolver: ICountryResolver
    val categoryResolver: ICategoryResolver
}
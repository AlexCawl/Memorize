package org.alexcawl.memorize.common

import dagger.Binds
import dagger.Module
import org.alexcawl.memorize.common.resolver.CategoryResolver
import org.alexcawl.memorize.common.resolver.CountryResolver
import org.alexcawl.memorize.common.resolver.ICategoryResolver
import org.alexcawl.memorize.common.resolver.ICountryResolver

@Module
interface CommonModule {
    @Binds
    fun bindCountryResolver(countryResolver: CountryResolver): ICountryResolver

    @Binds
    fun bindCategoryResolver(categoryResolver: CategoryResolver): ICategoryResolver
}
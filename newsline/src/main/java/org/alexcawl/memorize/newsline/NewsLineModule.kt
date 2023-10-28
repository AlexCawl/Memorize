package org.alexcawl.memorize.newsline

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.alexcawl.memorize.di.ViewModelKey
import org.alexcawl.memorize.di.ViewModelModule
import org.alexcawl.memorize.newsline.ui.current.CurrentNewsViewModel

@Module(includes = [ViewModelModule::class])
internal interface NewsLineModule {
    @Binds
    @IntoMap
    @ViewModelKey(CurrentNewsViewModel::class)
    fun bindCurrentNewsViewModel(viewModel: CurrentNewsViewModel): ViewModel
}
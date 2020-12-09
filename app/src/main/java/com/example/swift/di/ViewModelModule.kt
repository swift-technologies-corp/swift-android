package com.example.swift.di

import androidx.lifecycle.ViewModel
import com.example.swift.ui.FormViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FormViewModel::class)
    abstract fun bindMainViewModel(formViewModel: FormViewModel) : ViewModel
}
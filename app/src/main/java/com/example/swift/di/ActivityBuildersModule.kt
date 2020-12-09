package com.example.swift.di

import com.example.swift.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeMainActivity():MainActivity
}
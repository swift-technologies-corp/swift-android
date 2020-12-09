package com.example.swift.di

import android.app.Application
import androidx.room.Room
import com.example.swift.persistence.FormDao
import com.example.swift.persistence.FormDatabase
import com.example.swift.repository.FormRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun providesAppDatabase(app: Application): FormDatabase {
        return Room.databaseBuilder(app, FormDatabase::class.java, "form_database").build()
    }

    @Singleton
    @Provides
    fun providesFormDao(db: FormDatabase): FormDao {
        return db.formDao()
    }

    @Provides
    fun providesRepository(formDao: FormDao): FormRepository {
        return FormRepository(formDao)
    }
}
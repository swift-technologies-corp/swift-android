package com.example.swift.di

import android.app.Application
import androidx.room.Room
import com.example.swift.data.local.FormDao
import com.example.swift.data.local.FormDatabase
import com.example.swift.data.remote.FormRemoteDataSource
import com.example.swift.repository.FormRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("http://178.128.28.29:5000/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

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
    fun providesRepository(formDaoLocal: FormDao, fromRemoteDataSource: FormRemoteDataSource): FormRepository {
        return FormRepository(formDaoLocal, fromRemoteDataSource)
    }
}
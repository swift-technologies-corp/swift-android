package com.example.swift.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.swift.data.entities.Form

@Database(entities = [Form::class], version = 1)
abstract class FormDatabase: RoomDatabase() {
    abstract fun formDao(): FormDao
}
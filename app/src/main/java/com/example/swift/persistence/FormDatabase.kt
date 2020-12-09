package com.example.swift.persistence

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Form::class], version = 1)
abstract class FormDatabase: RoomDatabase() {
    abstract fun formDao(): FormDao
}
package com.example.swift.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.swift.data.entities.Form

@Dao
interface FormDao {

    @Insert
    fun insert(form: Form)

    @Delete
    fun delete(form: Form)

    @Update
    fun update(form: Form)

    @Query("SELECT * FROM tbl_form")
    fun getAllForms(): LiveData<List<Form>>

    @Query("SELECT * FROM tbl_form where id = :id")
    fun getForm(id: String) : LiveData<Form>

}
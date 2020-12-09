package com.example.swift.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import java.sql.RowId

@Dao
interface FormDao {

    @Insert
    fun insert(form: Form)

    @Delete
    fun delete(form: Form)

    @Update
    fun update(form: Form)

    @Query("select * from tbl_form")
    fun getAllForms(): LiveData<List<Form>>

}
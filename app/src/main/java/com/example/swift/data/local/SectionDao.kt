package com.example.swift.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.swift.data.entities.Section
import java.sql.RowId

@Dao
interface SectionDao {

    @Insert
    fun insert(section: Section)

    @Delete
    fun delete(section: Section)

    @Update
    fun update(section: Section)

    @Query("select * from tbl_section where formId is formId")
    fun getSectionsOfFormId(formId: RowId): LiveData<List<Section>>
}
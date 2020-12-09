package com.example.swift.persistence

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "tbl_section",
    foreignKeys = [ForeignKey(
        entity = Form::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("formId")
    )]
)
class Section(
    @PrimaryKey
    var id: String,
    var createdDate: String,
    var createdBy: String,
    var modifiedDate: String,
    var modifiedBy: String,
    var name: String,
    var displayLabel: String,
    var formId: String,
    var sortOrder: Int
)
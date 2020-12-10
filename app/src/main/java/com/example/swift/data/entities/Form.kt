package com.example.swift.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_form")
class Form(
    @PrimaryKey var id: String,
    var createdDate: String,
    var createdBy: String,
    var modifiedDate: String,
    var modifiedBy: String,
    var name: String,
    var displayLabel: String,
    var accountId: String,
    var sortOrder: Int
)
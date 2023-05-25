package com.example.danp_team01_exam01.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "report")
data class Report(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "report_id")
    val id: Int = 1,
    @ColumnInfo(name = "report_title")
    val title: String,
    @ColumnInfo(name = "report_image")
    val imageUrl: String,
    @ColumnInfo(name = "report_place")
    val place: String,
    @ColumnInfo(name = "report_description")
    val description: String,
    @ColumnInfo(name = "report_userEmail")
    val reportUserEmail: String
    )

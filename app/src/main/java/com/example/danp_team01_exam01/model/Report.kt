package com.example.danp_team01_exam01.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "report")
class Report {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "report_id")
    var id: Int = 0

    @ColumnInfo(name = "report_title")
    var title: String = ""

    @ColumnInfo(name = "report_image")
    var imageUrl: String = ""

    @ColumnInfo(name = "report_place")
    var place: String = ""

    @ColumnInfo(name = "report_description")
    var description: String = ""

    @ColumnInfo(name = "report_userEmail")
    var reportUserEmail: String = ""

    constructor(id: Int, title: String, imageUrl: String, place: String, description: String, reportUserEmail: String) {
        this.id = id
        this.title = title
        this.imageUrl = imageUrl
        this.place = place
        this.description = description
        this.reportUserEmail = reportUserEmail
    }
    @Ignore
    constructor(title: String, imageUrl: String, place: String, description: String, reportUserEmail: String) {
        this.title = title
        this.imageUrl = imageUrl
        this.place = place
        this.description = description
        this.reportUserEmail = reportUserEmail
    }
    @Ignore
    constructor(id: Int) {
        this.id = id
    }

}

package com.example.danp_team01_exam01.model

import androidx.lifecycle.LiveData
import androidx.room.Embedded
import androidx.room.Relation

data class UserWithReports(
    @Embedded val user: User,
    @Relation(
        parentColumn = "user_email",
        entityColumn = "report_userEmail")
    var reports: List<Report>
)

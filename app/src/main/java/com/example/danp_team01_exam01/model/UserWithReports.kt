package com.example.danp_team01_exam01.model

import androidx.lifecycle.LiveData
import androidx.room.Embedded
import androidx.room.Relation

data class UserWithReports(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userEmail",
        entityColumn = "reportUserEmail")
    var reports: LiveData<List<Report>>,
)

package com.example.danp_team01_exam01.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.danp_team01_exam01.model.Report

@Dao
interface UserWithReportsDao {
    @Transaction
    @Query("SELECT * FROM report WHERE report_userEmail = :userEmail")
    fun getUserWithReport(userEmail: String): List<Report>
}
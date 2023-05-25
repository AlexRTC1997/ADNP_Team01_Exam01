package com.example.danp_team01_exam01.data

import androidx.room.Delete
import androidx.room.Query
import com.example.danp_team01_exam01.model.Report

interface ReportDao {
    @Query("SELECT * FROM report WHERE report_id = :id")
    suspend fun getReport(id: Int): Report

    @Delete
    suspend fun deleteReport(report: Report)
}
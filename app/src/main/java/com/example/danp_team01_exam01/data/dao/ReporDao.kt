package com.example.danp_team01_exam01.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.danp_team01_exam01.model.Report

@Dao
interface ReportDao {
    @Query("SELECT * FROM report WHERE report_id = :id")
    suspend fun getReport(id: Int): Report

    @Insert
    suspend fun insertReport(report: Report)

    @Delete
    suspend fun deleteReport(report: Report)
}
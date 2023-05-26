package com.example.danp_team01_exam01.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.danp_team01_exam01.model.Report

@Dao
interface ReportDao {
    @Query("SELECT * FROM report WHERE report_id = :id")
    fun getReport(id: Int): Report

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertReport(report: Report)

    @Delete
    suspend fun deleteReport(report: Report)

    @Update
    suspend fun updateReport(report: Report)
}
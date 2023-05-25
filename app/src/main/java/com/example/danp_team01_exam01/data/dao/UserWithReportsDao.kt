package com.example.danp_team01_exam01.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.danp_team01_exam01.model.UserWithReports

@Dao
interface UserWithReportsDao {

    @Transaction
    @Query("SELECT * FROM report WHERE reportUserEmail = :userEmail")
    fun getUserWithReport(userEmail: String): LiveData<List<UserWithReports>>
}
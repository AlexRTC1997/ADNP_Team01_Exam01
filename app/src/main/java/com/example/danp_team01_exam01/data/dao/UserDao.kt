package com.example.danp_team01_exam01.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.danp_team01_exam01.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun registerUser(user: User)

    @Query("SELECT * FROM user WHERE user_email = :email AND user_password = :password")
    fun loginUser(email: String, password: String): User
}
package com.example.danp_team01_exam01.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.danp_team01_exam01.data.database.AppDatabase
import com.example.danp_team01_exam01.data.repository.AppRepository
import com.example.danp_team01_exam01.model.Report
import com.example.danp_team01_exam01.model.User
import com.example.danp_team01_exam01.model.UserWithReports
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {


    fun registerUser(user: User) {
        repository.registerUser(user)
    }

    fun loginUser(email: String, password: String) {
        repository.loginUser(email, password)
    }

    fun getReport(id: Int) {
        repository.getReport(id)
    }

    fun deleteReport(report: Report) {
        repository.deleteReport(report)
    }

    fun userWithReports(userEmail: String) {
        repository.getUserWithReport(userEmail)
    }
}
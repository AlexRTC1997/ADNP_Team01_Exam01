package com.example.danp_team01_exam01.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.danp_team01_exam01.data.database.AppDatabase
import com.example.danp_team01_exam01.data.repository.AppRepository
import com.example.danp_team01_exam01.model.Report
import com.example.danp_team01_exam01.model.User
import com.example.danp_team01_exam01.model.UserWithReports

class MainViewModel(application: Application) : ViewModel() {

    private val repository: AppRepository

    init {
        val appDatabase = AppDatabase.getInstance(application)
        val userDao = appDatabase.userDao()
        val reportsDao = appDatabase.reportDao()
        val userWithReportsDao = appDatabase.userWithReportsDao()

        repository = AppRepository(userDao, reportsDao, userWithReportsDao)
    }

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
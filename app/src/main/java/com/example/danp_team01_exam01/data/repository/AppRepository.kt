package com.example.danp_team01_exam01.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.danp_team01_exam01.data.ReportDao
import com.example.danp_team01_exam01.data.dao.UserDao
import com.example.danp_team01_exam01.data.dao.UserWithReportsDao
import com.example.danp_team01_exam01.model.Report
import com.example.danp_team01_exam01.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppRepository(
    private val userDao: UserDao,
    private val reportDao: ReportDao,
    private val userWithReportsDao: UserWithReportsDao
    ) {

    val foundUser = MutableLiveData<User>()
    val allReports = MutableLiveData<List<Report>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun registerUser(user: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.registerUser(user)
        }
    }

    fun insertReport(report: Report) {
        coroutineScope.launch(Dispatchers.IO) {
            reportDao.insertReport(report)
        }
    }

    fun loginUser(email: String, password: String) {
        coroutineScope.launch(Dispatchers.IO) {
            foundUser.postValue(userDao.loginUser(email, password))
        }
    }

    fun getReport(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            reportDao.getReport(id)
        }
    }

    fun deleteReport(report: Report) {
        coroutineScope.launch(Dispatchers.IO) {
            reportDao.deleteReport(report)
        }
    }

    fun getUserWithReport(userEmail: String) {
        coroutineScope.launch(Dispatchers.IO) {
            allReports.postValue(userWithReportsDao.getUserWithReport(userEmail))
        }
    }
}
package org.nuc.labs.repo

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.nuc.labs.db.dao.StudentDao
import org.nuc.labs.db.database.StudentDatabase
import org.nuc.labs.db.model.Student

class StudentRepository constructor(context: Context) {
    private lateinit var allStudentLiveData: LiveData<List<Student>>
    private val studentDao: StudentDao =
        StudentDatabase.getInstance(context).getStudentDao()

    init {
        GlobalScope.launch {
            allStudentLiveData = studentDao.getAllStudentLiveData()
        }
    }
}
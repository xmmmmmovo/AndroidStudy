package org.nuc.labs.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.nuc.labs.db.model.Student

@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudents(vararg students: Student)// 注: vararg->可变参数s

    @Update
    suspend fun updateStudents(vararg students: Student)

    @Delete
    suspend fun deleteStudents(vararg students: Student)

    @Query("select * from stud")
    suspend fun getAllStudentLiveData(): LiveData<List<Student>>
}
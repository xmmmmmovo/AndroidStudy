package org.nuc.labs.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.nuc.labs.db.dao.StudentDao
import org.nuc.labs.db.model.Student


/**
 * 设计的单例模式
 * */
@Database(
    entities = arrayOf(Student::class),
    version = 1,
    exportSchema = false
)
abstract class StudentDatabase private constructor() : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null
        fun getInstance(context: Context): StudentDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabase::class.java,
                    "student_database"
                )
                    .allowMainThreadQueries()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
    }

    abstract fun getStudentDao(): StudentDao
}
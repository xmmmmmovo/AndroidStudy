package org.nuc.labs.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.nuc.labs.db.dao.QuestoinDao
import org.nuc.labs.db.model.Queston

@Database(
    entities = arrayOf(Queston::class),
    version = 1,
    exportSchema = false
)
abstract class QuestionDatabase private constructor() : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: QuestionDatabase? = null
        fun getInstance(context: Context): QuestionDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    QuestionDatabase::class.java,
                    "question_database"
                )
                    .allowMainThreadQueries()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
    }

    abstract fun getQuestionDao(): QuestoinDao
}
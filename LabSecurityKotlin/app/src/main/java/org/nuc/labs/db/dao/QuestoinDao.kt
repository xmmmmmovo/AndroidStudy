package org.nuc.labs.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.nuc.labs.db.model.Queston

@Dao
interface QuestoinDao {
    @Insert
    suspend fun insertQuestion(vararg questons: Queston)// 注: vararg->可变参数s

    @Update
    suspend fun updateQuestion(vararg questons: Queston)

    @Delete
    suspend fun deleteQuestion(vararg questons: Queston)

    @Query("select * from tiku")
    fun getAllQuestioniveData(): LiveData<List<Queston>>
}
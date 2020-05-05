package org.nuc.labs.repo

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.nuc.labs.db.dao.QuestoinDao
import org.nuc.labs.db.database.QuestionDatabase
import org.nuc.labs.db.model.Queston

class QuestionRepository constructor(context: Context) {
    private lateinit var allQuestionLiveData: LiveData<List<Queston>>
    private val studentDao: QuestoinDao =
        QuestionDatabase.getInstance(context).getQuestionDao()

    init {
        GlobalScope.launch {
            allQuestionLiveData = studentDao.getAllQuestioniveData()
        }
    }
}
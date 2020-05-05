package org.nuc.labs.view.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import org.nuc.labs.databinding.ActivityStudyBinding

class StudyActivity : AppCompatActivity() {
    private val model by viewModels<StudyViewModel>()
    protected lateinit var binding: ActivityStudyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

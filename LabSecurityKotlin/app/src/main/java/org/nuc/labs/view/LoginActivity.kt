package org.nuc.labs.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.nuc.labs.R
import org.nuc.labs.databinding.ActivityLoginBinding
import org.nuc.labs.db.database.StudentDatabase
import org.nuc.labs.db.model.Student
import org.nuc.labs.view.review.ReviewActivity
import org.nuc.labs.view.study.StudyActivity
import org.nuc.labs.view.test.TestActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val modes = listOf("学习模式", "考试模式", "回看模式")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.exitButton.setOnClickListener {
            this.finish()
        }
        binding.loginButton.setOnClickListener {
            when (binding.modeSpinner.selectedItemPosition) {
                0 -> {
                    val i = Intent(
                        this@LoginActivity,
                        StudyActivity::class.java
                    )
                    i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(i)
                }
                1 -> {
                    val i = Intent(
                        this@LoginActivity,
                        TestActivity::class.java
                    )
                    i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(i)
                }
                2 -> {
                    val i = Intent(
                        this@LoginActivity,
                        ReviewActivity::class.java
                    )
                    i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(i)
                }
            }
        }
        ArrayAdapter(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            modes
        ).also {
            it.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            binding.modeSpinner.adapter = it
        }
        fakeData()
    }

    fun fakeData() {
        binding.nameEditText.setText("114514")
        binding.pwdEditText.setText("123456")
    }
}

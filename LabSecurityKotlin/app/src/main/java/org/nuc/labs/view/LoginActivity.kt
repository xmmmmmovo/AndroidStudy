package org.nuc.labs.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.nuc.labs.R
import org.nuc.labs.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.exitButton.setOnClickListener {
            this.finish()
        }
        binding.loginButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }
        fakeData()
    }

    fun fakeData() {
        binding.nameEditText.setText("114514")
        binding.pwdEditText.setText("123456")
    }
}

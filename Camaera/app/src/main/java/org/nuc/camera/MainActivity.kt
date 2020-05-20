package org.nuc.camera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.nuc.camera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.openButton.setOnClickListener {
        }

        binding.takeButton.setOnClickListener {
        }

        binding.closeButton.setOnClickListener {
        }
    }
}

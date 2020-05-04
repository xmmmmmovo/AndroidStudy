package org.nuc.labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.nuc.labs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindind.root)

        NavigationUI.setupActionBarWithNavController(
            this,
            findNavController(R.id.fragment)
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() ||
                findNavController(R.id.fragment).navigateUp()
    }
}

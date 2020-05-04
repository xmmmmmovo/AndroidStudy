package org.nuc.labs.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.nuc.labs.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

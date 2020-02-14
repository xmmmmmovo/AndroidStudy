package com.nuc.mk.view.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.nuc.mk.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val navController =
            findNavController(R.id.main_nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.filesFragment, R.id.settingsFragment
            ), drawer_layout
        )
        setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )
        main_nav_view.setupWithNavController(
            navController
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() ||
                findNavController(R.id.main_nav_host_fragment)
                    .navigateUp(appBarConfiguration)

    }
}

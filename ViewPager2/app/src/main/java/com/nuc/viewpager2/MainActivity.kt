package com.nuc.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewPager.adapter = object :
            FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 3

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> ScaleFragment()
                    1 -> RotateFragment()
                    2 -> TranslateFragment()
                    else -> TranslateFragment()
                }
            }
        }

        TabLayoutMediator(
            mainTabLayout, mainViewPager
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "缩放"
                1 -> tab.text = "旋转"
                2 -> tab.text = "移动"
            }
        }.attach()
    }
}

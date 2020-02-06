package com.mall.library.fragments.bottom

import android.widget.Toast
import com.mall.library.fragments.MallFragment

abstract class BottomItemFragment : MallFragment() {

    private var mTouchTime: Long = 0

    companion object {
        private const val WAIT_TIME = 2000L
    }

    override fun onBackPressedSupport(): Boolean {
        if (System.currentTimeMillis() - mTouchTime < WAIT_TIME) {
            _mActivity.finish()
        } else {
            mTouchTime = System.currentTimeMillis()
            Toast.makeText(_mActivity, "双击退出", Toast.LENGTH_SHORT).show()
        }

        return true
    }

}
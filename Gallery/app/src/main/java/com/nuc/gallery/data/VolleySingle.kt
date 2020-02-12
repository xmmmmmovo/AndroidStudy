package com.nuc.gallery.data

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class VolleySingle private constructor(context: Context) {

    companion object {
        private var INSTANCE: VolleySingle? = null
        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this) {
                VolleySingle(context)
                    .also { INSTANCE = it }
            }
    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }
}
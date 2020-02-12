package com.nuc.gallery.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.nuc.gallery.data.PhotoItem
import com.nuc.gallery.data.Pixabay
import com.nuc.gallery.data.VolleySingle

class GalleryViewModel(application: Application) :
    AndroidViewModel(application) {
    private val mPhotoListLive =
        MutableLiveData<List<PhotoItem>>()

    val photoListLive: LiveData<List<PhotoItem>>
        get() = mPhotoListLive

    fun resetQuery() {
        
    }

    fun fetchData() {
        val strRequest = StringRequest(
            Request.Method.GET,
            getUrl(),
            Response.Listener {
                mPhotoListLive.value =
                    Gson().fromJson(it, Pixabay::class.java)
                        .hits.toList()
            },
            Response.ErrorListener {
                Log.d("zha", it.toString())
            }
        )
            .also {
                VolleySingle.getInstance(getApplication())
                    .requestQueue.add(it)
            }

    }

    private fun getUrl(): String {
        return "https://pixabay.com/api/?" +
                "key=15151453-ada2236778a2f60f22030bccc&" +
                "q=${keyWords.random()}&" +
                "per_page=100"
    }

    private val keyWords = arrayOf("cat", "dog", "beauty", "phone")

}
package com.nuc.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.mall.library.net.callback.IFailure
import com.mall.library.net.callback.ISuccess
import com.nuc.libary.global.Mall
import com.nuc.libary.net.RestClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("main", "主函数")

        Mall.init(this)
            .withApiHost("http://mock.fulingjie.com/mock/api/")
            .configure()
        Log.d("api_tag", "api已被传入!")

        RestClient
            .builder()
            .url("index.php")
            .success(object : ISuccess {
                override fun onSuccess(response: String) {
                    Log.d("test_internet", response)
                    Toast.makeText(baseContext, response, Toast.LENGTH_LONG).show()
                }
            })
            .failure(object : IFailure {
                override fun onFailure() {
                    Toast.makeText(baseContext, "失败了。。", Toast.LENGTH_LONG).show()
                }
            })
            .build()
            .get()

    }
}

package com.mall.example

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.joanzapata.iconify.fonts.FontAwesomeModule
import com.mall.library.global.Mall
import com.mall.library.net.RestClient
import com.mall.library.net.callback.IFailure
import com.mall.library.net.callback.ISuccess
import com.nuc.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("main", "主函数")

        Mall.init(this)
            //假装网络有两秒钟的延迟，方便观察loading
            .withLoaderDelayed(0)
            .withIcon(FontAwesomeModule())
            //之后使用我远程部署的测试数据
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

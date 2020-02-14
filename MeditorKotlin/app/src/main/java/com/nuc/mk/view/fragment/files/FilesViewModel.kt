package com.nuc.mk.view.fragment.files

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nuc.mk.bean.MFile

class FilesViewModel : ViewModel() {

    private val users: MutableLiveData<List<MFile>> by lazy {
        MutableLiveData<List<MFile>>().also {
            getFiles()
        }
    }

    /**
     * 异步读取文件
     * */
    private fun getFiles(): ArrayList<MFile> {
        return ArrayList<MFile>()
    }

}

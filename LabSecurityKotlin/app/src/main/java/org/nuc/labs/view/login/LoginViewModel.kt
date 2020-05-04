package org.nuc.labs.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _name = MutableLiveData<String>().also {
        it.value = ""
    }
    val name: LiveData<String>
        get() = _name
}

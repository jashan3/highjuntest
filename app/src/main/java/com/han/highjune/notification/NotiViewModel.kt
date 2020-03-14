package com.han.highjune.notification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.han.highjune.model.NotiModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NotiViewModel :ViewModel(){
    private val _noti = MutableLiveData<List<NotiModel>>()
    val noti: LiveData<List<NotiModel>> = _noti


    init {
        refresh()
    }

    fun empty() {
        _noti.value = emptyList()
    }

    fun refresh(){
        viewModelScope.launch {
            delay(500)
            _noti.value = NotiModel.refresh()
        }
    }
}
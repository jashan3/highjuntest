package com.han.highjune.ViewModelList

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.han.highjune.model.Music
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VMListViewModel(context: Context):ViewModel(){
    private val _music = MutableLiveData<List<Music>>()
    val music: LiveData<List<Music>> = _music

    init {
        refresh(context)
    }

    fun empty() {
        _music.value = emptyList()
    }

    fun refresh(context: Context){
        viewModelScope.launch {
            delay(500)
            _music.value = Music.refresh(context)
        }
    }
}
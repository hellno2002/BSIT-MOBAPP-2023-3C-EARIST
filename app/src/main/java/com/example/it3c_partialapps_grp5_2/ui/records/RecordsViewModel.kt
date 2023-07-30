package com.example.it3c_partialapps_grp5_2.ui.records

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecordsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is records Fragment"
    }
    val text: LiveData<String> = _text
}
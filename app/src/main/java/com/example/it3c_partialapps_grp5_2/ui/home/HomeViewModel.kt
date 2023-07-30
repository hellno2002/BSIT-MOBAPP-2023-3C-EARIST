package com.example.it3c_partialapps_grp5_2.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val chosenDateLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val chosenDateLiveDataForDialogFragment: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val expensesFromVM: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val incomeFromVM: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val currentIncome: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}
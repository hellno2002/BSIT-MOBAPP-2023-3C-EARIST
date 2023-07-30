package com.example.it3c_partialapps_grp5_2.ui.accounts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountsViewModel : ViewModel() {

    val totalExpense: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>().apply { value = 0.0 }
    }
    val totalURI: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>().apply { value = 0.0 }
    }
    val updateCounter: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply { value = 1 }
    }
    val usageCount: LiveData<Int> by lazy {
        MutableLiveData<Int>().apply { value = 1 }
    }
    val updateCounterIncome: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply { value = 1 }
    }
    val usageCountIncome: LiveData<Int> by lazy {
        MutableLiveData<Int>().apply { value = 1 }
    }
    val selectedAccount: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply { value = "" }
    }
}
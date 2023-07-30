package com.example.it3c_partialapps_grp5_2.db.feb0122

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.it3c_partialapps_grp5_2.db.jan0122.DBViewModelJan0122

class DBViewModelFactoryFeb0122(private val dao: DaoFeb0122): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Checks if ViewModel (modelClass) is a subclass or child class of DBViewModel class
        if (modelClass.isAssignableFrom(DBViewModelFeb0122::class.java)) {
            return DBViewModelFeb0122(dao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}
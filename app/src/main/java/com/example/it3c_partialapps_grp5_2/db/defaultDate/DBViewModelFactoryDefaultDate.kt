package com.example.it3c_partialapps_grp5_2.db.defaultDate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.it3c_partialapps_grp5_2.db.jan0122.DBViewModelJan0122

class DBViewModelFactoryDefaultDate(private val dao: DaoDefaultDate): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Checks if ViewModel (modelClass) is a subclass or child class of DBViewModel class
        if (modelClass.isAssignableFrom(DBViewModelDefaultDate::class.java)) {
            return DBViewModelDefaultDate(dao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}
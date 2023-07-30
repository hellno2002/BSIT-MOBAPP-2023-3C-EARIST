package com.example.it3c_partialapps_grp5_2.db.jan0122

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DBViewModelFactoryJan0122(private val dao: DaoJan0122): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Checks if ViewModel (modelClass) is a subclass or child class of DBViewModel class
        if (modelClass.isAssignableFrom(DBViewModelJan0122::class.java)) {
            return DBViewModelJan0122(dao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}
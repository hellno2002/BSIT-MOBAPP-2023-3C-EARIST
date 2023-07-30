package com.example.it3c_partialapps_grp5_2.db.feb0122

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DBViewModelFeb0122(private val dao: DaoFeb0122): ViewModel() {
    fun insertEntityFromVM(entity: EntityFeb0122) = viewModelScope.launch {
        dao.insertEntity(entity)
    }
    fun updateEntityFromVM(entity: EntityFeb0122) = viewModelScope.launch {
        dao.updateEntity(entity)
    }
    fun deleteEntityFromVM(entity: EntityFeb0122) = viewModelScope.launch {
        dao.deleteEntity(entity)
    }
    val getAllEntityFromVM: LiveData<List<EntityFeb0122>> = dao.getALlEntity()
}
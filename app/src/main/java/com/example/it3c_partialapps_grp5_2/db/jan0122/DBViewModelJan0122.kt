package com.example.it3c_partialapps_grp5_2.db.jan0122

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DBViewModelJan0122(private val dao: DaoJan0122): ViewModel() {
    fun insertEntityFromVM(entity: EntityJan0122) = viewModelScope.launch {
        dao.insertEntity(entity)
    }
    fun updateEntityFromVM(entity: EntityJan0122) = viewModelScope.launch {
        dao.updateEntity(entity)
    }
    fun deleteEntityFromVM(entity: EntityJan0122) = viewModelScope.launch {
        dao.deleteEntity(entity)
    }
    val getAllEntityFromVM: LiveData<List<EntityJan0122>> = dao.getALlEntity()
}
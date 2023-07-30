package com.example.it3c_partialapps_grp5_2.db.feb0123

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DBViewModelFeb0123(private val dao: DaoFeb0123): ViewModel() {
    fun insertEntityFromVM(entity: EntityFeb0123) = viewModelScope.launch {
        dao.insertEntity(entity)
    }
    fun updateEntityFromVM(entity: EntityFeb0123) = viewModelScope.launch {
        dao.updateEntity(entity)
    }
    fun deleteEntityFromVM(entity: EntityFeb0123) = viewModelScope.launch {
        dao.deleteEntity(entity)
    }
    val getAllEntityFromVM: LiveData<List<EntityFeb0123>> = dao.getALlEntity()
}
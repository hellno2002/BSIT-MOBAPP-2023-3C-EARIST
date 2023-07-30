package com.example.it3c_partialapps_grp5_2.db.jan0123

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DBViewModelJan0123(private val dao: DaoJan0123): ViewModel() {
    fun insertEntityFromVM(entity: EntityJan0123) = viewModelScope.launch {
        dao.insertEntity(entity)
    }
    fun updateEntityFromVM(entity: EntityJan0123) = viewModelScope.launch {
        dao.updateEntity(entity)
    }
    fun deleteEntityFromVM(entity: EntityJan0123) = viewModelScope.launch {
        dao.deleteEntity(entity)
    }
    val getAllEntityFromVM: LiveData<List<EntityJan0123>> = dao.getALlEntity()
}
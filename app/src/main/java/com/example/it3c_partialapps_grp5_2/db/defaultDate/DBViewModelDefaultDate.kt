package com.example.it3c_partialapps_grp5_2.db.defaultDate

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DBViewModelDefaultDate(private val dao: DaoDefaultDate): ViewModel() {
    fun insertEntityFromVM(entity: EntityDefaultDate) = viewModelScope.launch {
        dao.insertEntity(entity)
    }
    fun updateEntityFromVM(entity: EntityDefaultDate) = viewModelScope.launch {
        dao.updateEntity(entity)
    }
    fun deleteEntityFromVM(entity: EntityDefaultDate) = viewModelScope.launch {
        dao.deleteEntity(entity)
    }
    val getAllEntityFromVM: LiveData<List<EntityDefaultDate>> = dao.getALlEntity()
}
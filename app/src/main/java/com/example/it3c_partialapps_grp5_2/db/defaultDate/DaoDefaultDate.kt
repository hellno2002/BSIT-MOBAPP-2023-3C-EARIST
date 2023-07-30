package com.example.it3c_partialapps_grp5_2.db.defaultDate

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoDefaultDate {
    @Insert
    suspend fun insertEntity(entity: EntityDefaultDate)

    @Update
    fun updateEntity(entity: EntityDefaultDate)

    @Delete
    fun deleteEntity(entity: EntityDefaultDate)

    @Query("SELECT * FROM default_table")
    fun getALlEntity(): LiveData<List<EntityDefaultDate>>

    @Query("DELETE FROM default_table")
    fun deleteAllEntity()
}
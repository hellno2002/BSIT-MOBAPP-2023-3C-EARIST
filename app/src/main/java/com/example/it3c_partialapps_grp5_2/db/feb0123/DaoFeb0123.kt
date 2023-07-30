package com.example.it3c_partialapps_grp5_2.db.feb0123

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoFeb0123 {
    @Insert
    suspend fun insertEntity(entity: EntityFeb0123)

    @Update
    fun updateEntity(entity: EntityFeb0123)

    @Delete
    fun deleteEntity(entity: EntityFeb0123)

    @Query("SELECT * FROM feb0123_table")
    fun getALlEntity(): LiveData<List<EntityFeb0123>>

    @Query("DELETE FROM feb0123_table")
    fun deleteAllEntity()
}
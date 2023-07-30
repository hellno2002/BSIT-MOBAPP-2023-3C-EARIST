package com.example.it3c_partialapps_grp5_2.db.feb0122

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoFeb0122 {
    @Insert
    suspend fun insertEntity(entity: EntityFeb0122)

    @Update
    fun updateEntity(entity: EntityFeb0122)

    @Delete
    fun deleteEntity(entity: EntityFeb0122)

    @Query("SELECT * FROM feb0122_table")
    fun getALlEntity(): LiveData<List<EntityFeb0122>>

    @Query("DELETE FROM feb0122_table")
    fun deleteAllEntity()
}
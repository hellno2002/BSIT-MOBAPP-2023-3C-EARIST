package com.example.it3c_partialapps_grp5_2.db.jan0122

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoJan0122 {
    @Insert
    suspend fun insertEntity(entity: EntityJan0122)

    @Update
    fun updateEntity(entity: EntityJan0122)

    @Delete
    fun deleteEntity(entity: EntityJan0122)

    @Query("SELECT * FROM jan0122_table")
    fun getALlEntity(): LiveData<List<EntityJan0122>>

    @Query("DELETE FROM jan0122_table")
    fun deleteAllEntity()
}
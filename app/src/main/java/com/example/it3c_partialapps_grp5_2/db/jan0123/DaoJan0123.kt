package com.example.it3c_partialapps_grp5_2.db.jan0123

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DaoJan0123 {
    @Insert
    suspend fun insertEntity(entity: EntityJan0123)

    @Update
    fun updateEntity(entity: EntityJan0123)

    @Delete
    fun deleteEntity(entity: EntityJan0123)

    @Query("SELECT * FROM jan0123_table")
    fun getALlEntity(): LiveData<List<EntityJan0123>>

    @Query("DELETE FROM jan0123_table")
    fun deleteAllEntity()
}
package com.example.it3c_partialapps_grp5_2.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.it3c_partialapps_grp5_2.db.defaultDate.DaoDefaultDate
import com.example.it3c_partialapps_grp5_2.db.defaultDate.EntityDefaultDate
import com.example.it3c_partialapps_grp5_2.db.feb0122.DaoFeb0122
import com.example.it3c_partialapps_grp5_2.db.feb0122.EntityFeb0122
import com.example.it3c_partialapps_grp5_2.db.feb0123.DaoFeb0123
import com.example.it3c_partialapps_grp5_2.db.feb0123.EntityFeb0123
import com.example.it3c_partialapps_grp5_2.db.jan0122.DaoJan0122
import com.example.it3c_partialapps_grp5_2.db.jan0122.EntityJan0122
import com.example.it3c_partialapps_grp5_2.db.jan0123.DaoJan0123
import com.example.it3c_partialapps_grp5_2.db.jan0123.EntityJan0123

@androidx.room.Database(entities = [
    EntityJan0122::class,
    EntityJan0123::class,
    EntityFeb0122::class,
    EntityFeb0123::class,
    EntityDefaultDate::class
                                   ], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun daoJan0122(): DaoJan0122
    abstract fun daoJan0123(): DaoJan0123
    abstract fun daoFeb0122(): DaoFeb0122
    abstract fun daoFeb0123(): DaoFeb0123
    abstract fun daoDefaultDate(): DaoDefaultDate

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "student_database"
            ).build().also {
                INSTANCE = it
            }
        }
    }
}
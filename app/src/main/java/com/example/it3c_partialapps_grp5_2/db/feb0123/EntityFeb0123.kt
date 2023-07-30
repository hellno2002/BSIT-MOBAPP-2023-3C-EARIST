package com.example.it3c_partialapps_grp5_2.db.feb0123

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feb0123_table")
data class EntityFeb0123(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("table_id")
    val id: Int,
    @ColumnInfo("feb0123_name")
    val product_name: String,
    @ColumnInfo("feb0123_type")
    val product_type: String,
    @ColumnInfo("feb0123_amount")
    val product_amount: String,
    @ColumnInfo("feb0123_rni")
    val product_rni: String,
    @ColumnInfo("feb0123_date")
    val product_date: String
)

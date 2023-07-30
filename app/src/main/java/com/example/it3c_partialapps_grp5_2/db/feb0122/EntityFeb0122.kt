package com.example.it3c_partialapps_grp5_2.db.feb0122

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feb0122_table")
data class EntityFeb0122(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("table_id")
    val id: Int,
    @ColumnInfo("feb0122_name")
    val product_name: String,
    @ColumnInfo("feb0122_type")
    val product_type: String,
    @ColumnInfo("feb0122_amount")
    val product_amount: String,
    @ColumnInfo("feb0122_rni")
    val product_rni: String,
    @ColumnInfo("feb0122_date")
    val product_date: String
)

package com.example.it3c_partialapps_grp5_2.db.defaultDate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "default_table")
data class EntityDefaultDate(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("table_id")
    val id: Int,
    @ColumnInfo("default_name")
    val product_name: String,
    @ColumnInfo("default_type")
    val product_type: String,
    @ColumnInfo("default_amount")
    val product_amount: String,
    @ColumnInfo("default_rni")
    val product_rni: String,
    @ColumnInfo("default_date")
    val product_date: String
)

package com.example.it3c_partialapps_grp5_2.db.jan0122

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jan0122_table")
data class EntityJan0122(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("table_id")
    val id: Int,
    @ColumnInfo("jan0122_name")
    val product_name: String,
    @ColumnInfo("jan0122_type")
    val product_type: String,
    @ColumnInfo("jan0122_amount")
    val product_amount: String,
    @ColumnInfo("jan0122_rni")
    val product_rni: String,
    @ColumnInfo("jan0122_date")
    val product_date: String
)

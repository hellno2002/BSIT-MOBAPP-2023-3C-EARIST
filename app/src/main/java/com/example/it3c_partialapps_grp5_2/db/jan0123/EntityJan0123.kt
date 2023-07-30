package com.example.it3c_partialapps_grp5_2.db.jan0123

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jan0123_table")
data class EntityJan0123(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("table_id")
    val id: Int,
    @ColumnInfo("jan0123_name")
    val product_name: String,
    @ColumnInfo("jan0123_type")
    val product_type: String,
    @ColumnInfo("jan0123_amount")
    val product_amount: String,
    @ColumnInfo("jan0123_rni")
    val product_rni: String,
    @ColumnInfo("jan0123_date")
    val product_date: String
)

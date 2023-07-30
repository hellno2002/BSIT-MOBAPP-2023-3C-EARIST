package com.example.it3c_partialapps_grp5_2.model

import android.net.Uri

data class HomeListModel(
    val transactionType: String,
    val transactionAmount: String,
    val transactionCashback: String,
    val transactionDate: String,
    val transactionProduct: String,
    val homeBackground: Uri
)
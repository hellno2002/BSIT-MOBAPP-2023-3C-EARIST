package com.example.it3c_partialapps_grp5_2.model

import android.net.Uri

data class AccountsCardListModel(
    val bankIcon: Uri,
    val bankName: String,
    val bankType: String,
    val bankCurrency: String
)
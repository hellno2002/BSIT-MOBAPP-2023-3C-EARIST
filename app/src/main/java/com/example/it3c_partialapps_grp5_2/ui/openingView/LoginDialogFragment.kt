package com.example.it3c_partialapps_grp5_2.ui.openingView

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.it3c_partialapps_grp5_2.R

class LoginDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("Logging in...")
            .create()

    companion object {
        const val TAG = "PurchaseConfirmationDialog"
    }
}
package com.example.it3c_partialapps_grp5_2.ui.openingView

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.text.color
import com.example.it3c_partialapps_grp5_2.R
import com.example.it3c_partialapps_grp5_2.databinding.BottomsheetFragmentConsentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AppBottomSheetFragment: BottomSheetDialogFragment() {
    private lateinit var _binding: BottomsheetFragmentConsentBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomsheetFragmentConsentBinding.inflate(inflater, container, false)
        sharedPreferences = requireActivity().getSharedPreferences("SharedPreferences_AppBottomSheetFragment", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        _binding.apply {
            val codeColor: Int = ContextCompat.getColor(requireContext(), R.color.theme_color_brown)
            val textFromBottomSheet = SpannableStringBuilder()
                .color(codeColor) { append("Data Privacy Statement:") }
                .append("The participants are assured that the personal data and other sensitive data entrusted to the Health Metric shall be used with due diligence and prudence, for the sole purpose of gathering registrations. ")
                .append("\n\n")
                .append("As such, upon accessing the registration form, you acknowledge and agree that the information may be used and disclosed by the Health Metric in accordance with any legal and regulatory standards and in compliance with the ")
                .color(codeColor) { append("\"Data Privacy Act of 2012\".") }

            tvConsentFromBottomSheet.text = textFromBottomSheet

            btnAgreeContinueFromConsentLayout.setOnClickListener {
                if (cbTermsAndConditions.isChecked) {
                    editor.apply {
                        putInt("ConsentVerification", 1)
                        commit()
                    }
                    dismiss()
                    startActivity(Intent(requireContext(), MainLoginActivity::class.java))
                } else {
                    Toast.makeText(requireContext(), "Please agree to the terms and conditions first before proceeding", Toast.LENGTH_LONG).show()
                }
            }
        }

        return _binding.root
    }
}
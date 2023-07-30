package com.example.it3c_partialapps_grp5_2.ui.accounts

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.it3c_partialapps_grp5_2.R
import com.example.it3c_partialapps_grp5_2.databinding.FragmentAccountBottomSheetListDialogBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Customize parameter argument names
const val ARG_ITEM_COUNT = "item_count"

/**
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    AccountBottomSheetFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 */
class AccountBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentAccountBottomSheetListDialogBinding? = null
    private lateinit var accountsViewModel: AccountsViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAccountBottomSheetListDialogBinding.inflate(inflater, container, false)
        accountsViewModel = ViewModelProvider(requireActivity())[AccountsViewModel::class.java]


        _binding?.apply {
            btnCancel.setOnClickListener {
                dismiss()
            }
            btnProceed.setOnClickListener {
                if (rgMain.checkedRadioButtonId == -1) {
                    Toast.makeText(requireView().context, "Please choose an account", Toast.LENGTH_LONG).show()
                } else {
                    val radioButtonID = rgMain.checkedRadioButtonId
                    val radioButton = view?.findViewById<RadioButton>(radioButtonID)
                    val radioButtonText = radioButton?.text.toString()

                    accountsViewModel.selectedAccount.value = radioButtonText
                    Log.i("MyTag", accountsViewModel.selectedAccount.value.toString() + "from dialog")
                    dismiss()
                }
            }
        }

        return binding.root

    }



    companion object {

        // TODO: Customize parameters
        fun newInstance(itemCount: Int): AccountBottomSheetFragment =
            AccountBottomSheetFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ITEM_COUNT, itemCount)
                }
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
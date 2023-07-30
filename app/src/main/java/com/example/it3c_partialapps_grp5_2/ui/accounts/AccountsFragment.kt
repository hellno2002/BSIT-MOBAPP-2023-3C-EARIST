package com.example.it3c_partialapps_grp5_2.ui.accounts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.it3c_partialapps_grp5_2.R
import com.example.it3c_partialapps_grp5_2.adapter.AccountsCardListAdapter
import com.example.it3c_partialapps_grp5_2.databinding.FragmentAccountsBinding
import com.example.it3c_partialapps_grp5_2.model.AccountsCardListModel
import com.example.it3c_partialapps_grp5_2.ui.openingView.LoginActivity
import com.example.it3c_partialapps_grp5_2.utils.ListItem
import java.text.DecimalFormat

class AccountsFragment : Fragment()  {

    private var _binding: FragmentAccountsBinding? = null
    private lateinit var adapterCards: AccountsCardListAdapter
    private lateinit var adapterDigitalBank: AccountsCardListAdapter
    private lateinit var accountsViewModel: AccountsViewModel
    private lateinit var decimalFormat: DecimalFormat

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapterCards = AccountsCardListAdapter(ListItem.listForAccountsCardListAdapter)
        adapterDigitalBank = AccountsCardListAdapter(ListItem.listForAccountsDigitalBankListAdapter)
        accountsViewModel = ViewModelProvider(requireActivity())[AccountsViewModel::class.java]
        decimalFormat = DecimalFormat(resources.getString(R.string.decimal_format_format))

        _binding = FragmentAccountsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        _binding?.apply {
            rvMainCards.adapter = adapterCards
            rvMainDigitalBank.adapter = adapterDigitalBank
            tvAccountsRemainingAmount.text = "\$ " + decimalFormat.format(ListItem.accountsViewModel.totalExpense.value.toString()?.toDouble())
            tvUIR.text = "\$ " + decimalFormat.format(ListItem.accountsViewModel.totalURI.value.toString()?.toDouble())

            accountsViewModel.selectedAccount.observe(viewLifecycleOwner, Observer {
                Log.i("MyTag", accountsViewModel.selectedAccount.value.toString() + " fromObserver")
                when (it) {
                    "EON by UnionBank" -> {
                        ListItem.listForAccountsDigitalBankListAdapter.add(AccountsCardListModel(
                            Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/eonunionbank"),
                            "EON", "Digital bank", "PHP/USD"
                        ))
                    }
                    "Komo by EastWest" -> {
                        ListItem.listForAccountsDigitalBankListAdapter.add(AccountsCardListModel(
                                Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/komo"),
                                "Komo", "Digital bank", "PHP/USD"
                        ))
                    }
                    "UNOBank" -> {
                        ListItem.listForAccountsDigitalBankListAdapter.add(AccountsCardListModel(
                                Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/unobank"),
                                "UNOBank", "Digital bank", "PHP/USD"
                        ))
                    }
                }
                adapterDigitalBank.notifyDataSetChanged()
            })

            cvAccountsBSD.setOnClickListener {
                AccountBottomSheetFragment.newInstance(30).show(requireFragmentManager(), "dialog")
            }

            fabExitFromAccounts.setOnClickListener { startActivity(Intent(requireContext(), LoginActivity::class.java)) }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
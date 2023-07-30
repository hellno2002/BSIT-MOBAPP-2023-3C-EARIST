package com.example.it3c_partialapps_grp5_2.ui.records

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.it3c_partialapps_grp5_2.R
import com.example.it3c_partialapps_grp5_2.adapter.HomeListAdapter
import com.example.it3c_partialapps_grp5_2.adapter.RecordsListAdapter
import com.example.it3c_partialapps_grp5_2.databinding.FragmentRecordsBinding
import com.example.it3c_partialapps_grp5_2.ui.accounts.AccountsViewModel
import com.example.it3c_partialapps_grp5_2.ui.openingView.LoginActivity
import com.example.it3c_partialapps_grp5_2.utils.ListItem

class RecordsFragment : Fragment() {

    private var _binding: FragmentRecordsBinding? = null
    private lateinit var adapter: RecordsListAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel = ViewModelProvider(this)[RecordsViewModel::class.java]
        adapter = RecordsListAdapter(ListItem.listForRecordsListModel)

        _binding = FragmentRecordsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        _binding?.apply {
            rvMain.adapter = adapter

            cvExpenses.setBackgroundResource(R.drawable.records_choices_theme_color)
            tvExpensesRawText.setTextColor(resources.getColor(R.color.white))

            cvExpenses.setOnClickListener {
                rvMain.adapter = adapter

                cvIncome.setBackgroundResource(R.drawable.records_choices_white)
                tvIncomeRawText.setTextColor(resources.getColor(R.color.theme_color_grey))
                cvExpenses.setBackgroundResource(R.drawable.records_choices_theme_color)
                tvExpensesRawText.setTextColor(resources.getColor(R.color.white))
            }
            cvIncome.setOnClickListener {
                rvMain.adapter = RecordsListAdapter(ListItem.listForRecordsListModelIncome)

                cvIncome.setBackgroundResource(R.drawable.records_choices_theme_color)
                tvIncomeRawText.setTextColor(resources.getColor(R.color.white))
                cvExpenses.setBackgroundResource(R.drawable.records_choices_white)
                tvExpensesRawText.setTextColor(resources.getColor(R.color.theme_color_grey))
            }
            fabExitFromRecords.setOnClickListener { startActivity(Intent(requireContext(), LoginActivity::class.java)) }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.it3c_partialapps_grp5_2.ui.history

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.it3c_partialapps_grp5_2.adapter.HistoryListAdapter
import com.example.it3c_partialapps_grp5_2.databinding.FragmentHistoryBinding
import com.example.it3c_partialapps_grp5_2.ui.home.HomeViewModel
import com.example.it3c_partialapps_grp5_2.ui.openingView.LoginActivity
import com.example.it3c_partialapps_grp5_2.utils.ListItem
import java.util.Calendar

class HistoryFragment : Fragment() {
    private lateinit var viewModel: HistoryViewModel
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var _binding: FragmentHistoryBinding
    private lateinit var adapter: HistoryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        adapter = HistoryListAdapter(ListItem.listForHistoryListModel)
        viewModel = HistoryViewModel()
        homeViewModel = HomeViewModel()
        val calendar: Calendar = Calendar.getInstance()
        var calendarYear: Int = calendar.get(Calendar.YEAR)
        var calendarMonth: Int = calendar.get(Calendar.MONTH)
        var calendarDay: Int = calendar.get(Calendar.DAY_OF_MONTH)

        _binding.apply {
            rvHistoryMain.adapter = adapter

            tvHistoryHeader.text = "Transactions as of ${calendarYear}/${calendarDay}/${calendarMonth + 1}"

            fabExitFromHistory.setOnClickListener { startActivity(Intent(requireContext(), LoginActivity::class.java)) }

            return _binding.root
        }
    }
}
package com.example.it3c_partialapps_grp5_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.it3c_partialapps_grp5_2.databinding.HistoryListItemBinding
import com.example.it3c_partialapps_grp5_2.model.HistoryListModel

class HistoryListAdapter(
    private val collections: List<HistoryListModel>
): RecyclerView.Adapter<HistoryListAdapter.HistoryListViewHolder>() {
    inner class HistoryListViewHolder(private val _binding: HistoryListItemBinding): RecyclerView.ViewHolder(_binding.root) {
        fun bind(historyListModel: HistoryListModel) {
            _binding.apply {
                tvExpensesAmount.text = historyListModel.expensesAmount
                tvDateAndTime.text = historyListModel.dateAndTime
                tvItem.text = historyListModel.itemName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryListViewHolder {
        val binding: HistoryListItemBinding = HistoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryListViewHolder(binding)
    }

    override fun getItemCount(): Int = collections.size

    override fun onBindViewHolder(holder: HistoryListViewHolder, position: Int) = holder.bind(collections[position])
}
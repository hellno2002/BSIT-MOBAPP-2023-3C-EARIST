package com.example.it3c_partialapps_grp5_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.it3c_partialapps_grp5_2.R
import com.example.it3c_partialapps_grp5_2.databinding.RecordsListItemBinding
import com.example.it3c_partialapps_grp5_2.model.RecordsListModel

class RecordsListAdapter(
    private val collections: MutableList<RecordsListModel>
): RecyclerView.Adapter<RecordsListAdapter.RecordsListViewHolder>() {
    inner class RecordsListViewHolder(private val _binding: RecordsListItemBinding): RecyclerView.ViewHolder(_binding.root) {
        fun bind(recordsListModel: RecordsListModel) {
            _binding.apply {
                tvAmount.text = recordsListModel.recordsExpenses
                tvType.text = recordsListModel.recordsType
                tvDate.text = recordsListModel.recordsDate
                cvCircleColor.setBackgroundResource(R.drawable.records_bg_circl)
                tvFirstLetter.text = recordsListModel.recordsTypeFirstLetter
//                cvCircleColor.setCardBackgroundColor(recordsListModel.recordsCircleColor)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordsListViewHolder {
        val binding: RecordsListItemBinding = RecordsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecordsListViewHolder(binding)
    }

    override fun getItemCount(): Int = collections.size

    override fun onBindViewHolder(holder: RecordsListViewHolder, position: Int) = holder.bind(collections[position])
}
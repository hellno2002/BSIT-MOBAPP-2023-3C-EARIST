package com.example.it3c_partialapps_grp5_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.it3c_partialapps_grp5_2.databinding.HomeListItemBinding
import com.example.it3c_partialapps_grp5_2.model.HomeListModel

class HomeListAdapter(
    private val collections: List<HomeListModel>
): RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {
    inner class HomeListViewHolder(private val _binding: HomeListItemBinding): RecyclerView.ViewHolder(_binding.root) {
        fun bind(homeListModel: HomeListModel) {
            _binding.apply {
                tvTransactionType.text = "Type:  " + homeListModel.transactionType
                tvTransactionAmount.text = "Amount:  " + homeListModel.transactionAmount
                tvTransactionCashback.text = "Cashback:  " + homeListModel.transactionCashback
                tvTransactionDate.text = "Date:  " + homeListModel.transactionDate
                tvTransactionProduct.text = homeListModel.transactionProduct
                ivHomeBackground.setImageURI(homeListModel.homeBackground)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val binding: HomeListItemBinding = HomeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeListViewHolder(binding)
    }

    override fun getItemCount(): Int = collections.size

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) = holder.bind(collections[position])

    fun getAmountAtPosition(position: Int): String = collections[position].transactionAmount

    fun getCashbackAtPosition(position: Int): String = collections[position].transactionCashback
}
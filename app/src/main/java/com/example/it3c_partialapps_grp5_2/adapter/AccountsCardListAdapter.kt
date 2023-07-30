package com.example.it3c_partialapps_grp5_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.it3c_partialapps_grp5_2.databinding.AccountsCardsListItemBinding
import com.example.it3c_partialapps_grp5_2.model.AccountsCardListModel

class AccountsCardListAdapter(
    private val collections: MutableList<AccountsCardListModel>
): RecyclerView.Adapter<AccountsCardListAdapter.AccountsCardListViewHolder>() {
    inner class AccountsCardListViewHolder(private val _binding: AccountsCardsListItemBinding): RecyclerView.ViewHolder(_binding.root) {
        fun bind(accountsCardListModel: AccountsCardListModel) {
            _binding.apply {
                ivBankIcon.setImageURI(accountsCardListModel.bankIcon)
                tvBankName.text = accountsCardListModel.bankName
                tvBankType.text = accountsCardListModel.bankType
                tvCurrency.text = accountsCardListModel.bankCurrency
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountsCardListViewHolder {
        val binding: AccountsCardsListItemBinding = AccountsCardsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return AccountsCardListViewHolder(binding)
    }

    override fun getItemCount(): Int = collections.size

    override fun onBindViewHolder(holder: AccountsCardListViewHolder, position: Int) = holder.bind(collections[position])
}
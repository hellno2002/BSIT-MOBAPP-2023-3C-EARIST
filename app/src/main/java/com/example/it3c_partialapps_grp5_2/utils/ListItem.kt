package com.example.it3c_partialapps_grp5_2.utils

import android.net.Uri
import com.example.it3c_partialapps_grp5_2.model.AccountsCardListModel
import com.example.it3c_partialapps_grp5_2.model.HistoryListModel
import com.example.it3c_partialapps_grp5_2.model.HomeListModel
import com.example.it3c_partialapps_grp5_2.model.RecordsListModel
import com.example.it3c_partialapps_grp5_2.ui.accounts.AccountsViewModel

object ListItem {

    // January 01, 2022
    val listForHomeListAdapterJanuary012022: List<HomeListModel> = listOf(
        HomeListModel("Rent","$ 1,200.00", "$ 0.00", "January 01, 2022", "Toothbrush", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fifthbackground")),
        HomeListModel("Groceries", "$ 234.56", "$ 1.23", "January 01, 2022", "Backpack", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fifthbackground")),
        HomeListModel("Entertainment", "$ 67.89", "$ 2.34", "January 01, 2022", "Coffee mug", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fifthbackground")),
        HomeListModel("Gas", "$ 45.67", "$ 0.76", "January 01, 2022", "Umbrella", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fifthbackground")),
        HomeListModel("Shopping", "$ 321.98", "$ 3.45", "January 01, 2022", "Sunglasses", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fifthbackground")),
        HomeListModel("Dining Out", "$ 98.76", "$ 1.11", "January 01, 2022", "Hand sanitizer", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fifthbackground")),
        HomeListModel("Travel", "$ 543.21", "$ 5.67", "January 01, 2022", "Headphones", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fifthbackground")),
        HomeListModel("Education", "$ 876.54", "$ 7.89", "January 01, 2022", "Dumbbells", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fifthbackground")),
        HomeListModel("Healthcare", "$ 210.98", "$ 2.12", "January 01, 2022", "T-shirt", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fifthbackground")),
        HomeListModel("Charity", "$ 123.45", "$ 1.01", "January 01, 2022", "Laptop", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fifthbackground"))
    )

    // February 01, 2022
    val listForHomeListAdapterFebruary012022: List<HomeListModel> = listOf(
        HomeListModel("Groceries", "$ 80.50", "$ 2.25", "February 01, 2022", "Hairdryer", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fourthbackground")),
        HomeListModel("Entertainment", "$ 150.75", "$ 6.20", "February 01, 2022", "Alarm clock", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fourthbackground")),
        HomeListModel("Shopping", "$ 250.30", "$ 10.40", "February 01, 2022", "Water bottle", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fourthbackground")),
        HomeListModel("Gas", "$ 40.20", "$ 1.50", "February 01, 2022", "Pencil case", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fourthbackground")),
        HomeListModel("Dining Out", "$ 75.60", "$ 3.80", "February 01, 2022", "Board game", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fourthbackground")),
        HomeListModel("Travel", "$ 600.00", "$ 12.00", "February 01, 2022", "Sneakers", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fourthbackground")),
        HomeListModel("Healthcare", "$ 200.25", "$ 5.75", "February 01, 2022", "Smartphone case", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fourthbackground")),
        HomeListModel("Education", "$ 320.90", "$ 8.70", "February 01, 2022", "Wallet", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fourthbackground")),
        HomeListModel("Charity", "$ 50.00", "$ 2.00", "February 01, 2022", "Wristwatch", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fourthbackground")),
        HomeListModel("Investment", "$ 1000.00", "$ 15.00", "February 01, 2022", "Cooking pot", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/fourthbackground"))
    )

    // February 01, 2023
    val listForHomeListAdapterFebruary012023: List<HomeListModel> = listOf(
        HomeListModel("Groceries", "$ 356.89", "$ 4.32", "February 01, 2023", "Yoga mat", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/thirdbackground")),
        HomeListModel("Entertainment", "$ 76.55", "$ 1.20", "February 01, 2023", "Blender", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/thirdbackground")),
        HomeListModel("Travel", "$ 1,234.50", "$ 23.45", "February 01, 2023", "Baby stroller", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/thirdbackground")),
        HomeListModel("Dining", "$ 72.30", "$ 2.50", "February 01, 2023", "Shampoo", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/thirdbackground")),
        HomeListModel("Shopping", "$ 259.99", "$ 5.00", "February 01, 2023", "Nail polish", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/thirdbackground")),
        HomeListModel("Healthcare", "$ 215.45", "$ 6.78", "February 01, 2023", "Fishing rod", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/thirdbackground")),
        HomeListModel("Gifts", "$ 150.00", "$ 0.00", "February 01, 2023", "Tennis racket", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/thirdbackground")),
        HomeListModel("Charity", "$ 50.00", "$ 10.00", "February 01, 2023", "Picture frame", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/thirdbackground")),
        HomeListModel("Education", "$ 435.90", "$ 15.20", "February 01, 2023", "Candle", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/thirdbackground")),
        HomeListModel("Investment", "$ 1,200.00", "$ 35.50", "February 01, 2023", "Bicycle helmet", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/thirdbackground"))
    )

    // For January 01, 2023
    val listForHomeListAdapterJanuary012023: List<HomeListModel> = listOf(
        HomeListModel("Shopping", "$ 250.00", "$ 5.00", "January 01, 2023", "Puzzle", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/secondbackground")),
        HomeListModel("Entertainment", "$ 100.75", "$ 2.50", "January 01, 2023", "Oven mitts", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/secondbackground")),
        HomeListModel("Groceries", "$ 350.40", "$ 8.20", "January 01, 2023", "Backpacking tent", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/secondbackground")),
        HomeListModel("Dining Out", "$ 75.99", "$ 3.80", "January 01, 2023", "Digital camera", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/secondbackground")),
        HomeListModel("Travel", "$ 500.00", "$ 15.00", "January 01, 2023", "Bath towel", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/secondbackground")),
        HomeListModel("Healthcare", "$ 200.50", "$ 4.50", "January 01, 2023", "Power bank", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/secondbackground")),
        HomeListModel("Investments", "$ 1000.00", "$ 20.00", "January 01, 2023", "Electric toothbrush", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/secondbackground")),
        HomeListModel("Charity", "$ 50.00", "$ 1.50", "January 01, 2023", "Cutting board", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/secondbackground")),
        HomeListModel("Transportation", "$ 80.25", "$ 2.75", "January 01, 2023", "Microwave oven", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/secondbackground")),
        HomeListModel("Education", "$ 400.60", "$ 10.00", "January 01, 2023", "Travel adapter", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/secondbackground"))
    )

    // For July 02, 2023  or DefaultDate
    val listForHomeListAdapterJuly022023: List<HomeListModel> = listOf(
        HomeListModel("Utilities", "$ 3,400.21", "$ 14.75", "July 02, 2023", "Guitar strings", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/firstbackground")),
        HomeListModel("Taxes", "$ 5,423.31", "$ 12.23", "July 02, 2023", "Yoga pants", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/firstbackground")),
        HomeListModel("Bills", "$ 534.64", "$ 10.65", "July 02, 2023", "Sunglasses case", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/firstbackground")),
        HomeListModel("Insurance", "$ 1,232.84", "$ 7.38", "July 02, 2023", "Sleeping bag", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/firstbackground")),
        HomeListModel("Utilities", "$ 2,442.2", "$ 7.16", "July 02, 2023", "Duffle bag", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/firstbackground")),
        HomeListModel("Mortgage", "$ 7,432.52", "$ 4.77", "July 02, 2023", "Perfume", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/firstbackground")),
        HomeListModel("Utilities", "$ 3,400.21", "$ 75.35", "July 02, 2023", "Gardening gloves", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/firstbackground")),
        HomeListModel("Bills", "$ 12,233.51", "$ 64.37", "July 02, 2023", "Chess set", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/firstbackground")),
        HomeListModel("Bills", "$ 9,422.86", "$ 23.97", "July 02, 2023", "Electric kettle", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/firstbackground")),
        HomeListModel("Utilities", "$ 7,421.16", "$ 35.22", "July 02, 2023", "Video game controller", Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/firstbackground"))
    )

    private val storeItems: Array<Array<String>> = arrayOf(
        arrayOf("Toothbrush", "Backpack", "Coffee mug", "Umbrella", "Sunglasses", "Hand sanitizer", "Headphones", "Dumbbells", "T-shirt", "Laptop"),
        arrayOf("Hairdryer", "Alarm clock", "Water bottle", "Pencil case", "Board game", "Sneakers", "Smartphone case", "Wallet", "Wristwatch", "Cooking pot"),
        arrayOf("Yoga mat", "Blender", "Baby stroller", "Shampoo", "Nail polish", "Fishing rod", "Tennis racket", "Picture frame", "Candle", "Bicycle helmet"),
        arrayOf("Puzzle", "Oven mitts", "Backpacking tent", "Digital camera", "Bath towel", "Power bank", "Electric toothbrush", "Cutting board", "Microwave oven", "Travel adapter"),
        arrayOf("Guitar strings", "Yoga pants", "Sunglasses case", "Sleeping bag", "Duffle bag", "Perfume", "Gardening gloves", "Chess set", "Electric kettle", "Video game controller")
    )

    private val randomTimes: Array<Array<String>> = arrayOf(
        arrayOf("09:32 AM", "01:17 PM", "05:44 AM", "10:58 PM", "03:25 AM", "07:03 PM", "11:11 AM", "06:39 PM", "02:52 AM", "08:16 AM"),
        arrayOf( "04:07 PM", "12:40 AM", "09:58 PM", "01:33 PM", "05:15 AM", "10:29 PM", "03:51 AM", "07:22 PM", "11:49 AM", "06:08 PM"),
        arrayOf("02:14 AM", "08:47 AM", "04:03 PM", "12:26 AM", "09:11 PM", "01:59 PM", "05:33 AM", "10:40 PM", "03:12 AM", "07:55 PM"),
        arrayOf("11:22 AM", "06:05 PM", "02:38 AM", "08:09 AM", "04:21 PM", "12:54 AM", "09:37 PM", "01:47 PM", "05:05 AM", "10:11 PM"),
        arrayOf("03:41 AM", "07:17 PM", "11:38 AM", "06:30 PM", "02:23 AM", "08:33 AM", "04:52 PM", "12:04 AM", "09:22 PM", "01:26 PM")
    )

    private val listOfExpenses = listOf(
        listForHomeListAdapterJanuary012022.map { it.transactionAmount },
        listForHomeListAdapterFebruary012022.map { it.transactionAmount },
        listForHomeListAdapterJanuary012023.map { it.transactionAmount },
        listForHomeListAdapterFebruary012023.map { it.transactionAmount },
        listForHomeListAdapterJuly022023.map { it.transactionAmount }
    )

    private val listOfDate = listOf(
        listForHomeListAdapterJanuary012022.map { it.transactionDate },
        listForHomeListAdapterFebruary012022.map { it.transactionDate },
        listForHomeListAdapterJanuary012023.map { it.transactionDate },
        listForHomeListAdapterFebruary012023.map { it.transactionDate },
        listForHomeListAdapterJuly022023.map { it.transactionDate }
    )

    private val listOfTypes = listOf(
        listForHomeListAdapterJanuary012022.map { it.transactionType },
        listForHomeListAdapterFebruary012022.map { it.transactionType },
        listForHomeListAdapterJanuary012023.map { it.transactionType },
        listForHomeListAdapterFebruary012023.map { it.transactionType },
        listForHomeListAdapterJuly022023.map { it.transactionType }
    )

    private val listOfIncome = listOf(
        listForHomeListAdapterJanuary012022.map { it.transactionCashback },
        listForHomeListAdapterFebruary012022.map { it.transactionCashback },
        listForHomeListAdapterJanuary012023.map { it.transactionCashback },
        listForHomeListAdapterFebruary012023.map { it.transactionCashback },
        listForHomeListAdapterJuly022023.map { it.transactionCashback }
    )

    private val listOfTypesIncome = listOf(
        listForHomeListAdapterJanuary012022.map { it.transactionType },
        listForHomeListAdapterFebruary012022.map { it.transactionType },
        listForHomeListAdapterJanuary012023.map { it.transactionType },
        listForHomeListAdapterFebruary012023.map { it.transactionType },
        listForHomeListAdapterJuly022023.map { it.transactionType }
    )

    val listForRecordsListModel: MutableList<RecordsListModel> = mutableListOf()
    val listForHistoryListModel: MutableList<HistoryListModel> = mutableListOf()
    val accountsViewModel: AccountsViewModel = AccountsViewModel()
    fun fillArrayExpenses() {
        if (accountsViewModel.updateCounter.value == accountsViewModel.usageCount.value) {
            for (i in 0 until 5) {
                for (j in 0 until 10) {
                    val expense = listOfExpenses[i][j]
                    accountsViewModel.totalExpense.value = accountsViewModel.totalExpense.value?.plus(
                        expense.toString().removeRange(0, 1).replace(" ", "").replace(",", "").toDouble()
                    )
                    val date = listOfDate[i][j]
                    val type = listOfTypes[0][j]
                    val typeInitial = listOfTypes[0][j].toString()[0].toString()
                    val record = RecordsListModel(expense, date, type, typeInitial)
                    listForRecordsListModel.add(record)
                    listForHistoryListModel.add(HistoryListModel(storeItems[i][j], date + ", " + randomTimes[i][j], expense))
                }
            }
            accountsViewModel.updateCounter.value = accountsViewModel.updateCounter.value!! + 1
        }
    }

    val listForRecordsListModelIncome: MutableList<RecordsListModel> = mutableListOf()
    fun fillArrayIncome() {
        if (accountsViewModel.updateCounterIncome.value == accountsViewModel.usageCountIncome.value) {
            for (i in 0 until 5) {
                for (j in 0 until 10) {
                    val income = listOfIncome[i][j]
                    accountsViewModel.totalURI.value = accountsViewModel.totalURI.value?.plus(
                        income.toString().removeRange(0, 1).replace(" ", "").replace(",", "").toDouble()
                    )
                    val date = listOfDate[i][j]
                    val type = listOfTypesIncome[0][j]
                    val typeInitial = listOfTypes[0][j].toString()[0].toString()
                    val record = RecordsListModel(income, date, type, typeInitial)
                    listForRecordsListModelIncome.add(record)
                }
            }
            accountsViewModel.updateCounterIncome.value = accountsViewModel.updateCounterIncome.value!! + 1
        }
    }

    val listForAccountsCardListAdapter: MutableList<AccountsCardListModel> = mutableListOf(
        AccountsCardListModel(Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/chase"), "Chase Bank", "Credit card", "USD"),
        AccountsCardListModel(Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/mastercard"), "Mastercard", "Credit card", "USD"),
        AccountsCardListModel(Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/visa"), "Visa", "Credit card", "USD")
    )

    val listForAccountsDigitalBankListAdapter: MutableList<AccountsCardListModel> = mutableListOf(
        AccountsCardListModel(Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/cimbresizedd"), "CIMB", "Digital bank", "USD/PHP"),
        AccountsCardListModel(Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/gcashresized"), "GCash", "Digital bank", "USD/PHP"),
        AccountsCardListModel(Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/mayaresized"), "Maya", "Digital bank", "USD/PHP"),
        AccountsCardListModel(Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/netbankresized"), "Netbank", "Digital bank", "USD/PHP"),
        AccountsCardListModel(Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/seabankresized"), "Seabank", "Digital bank", "USD/PHP"),
        AccountsCardListModel(Uri.parse("android.resource://com.example.it3c_partialapps_grp5_2/drawable/tonikresized"), "Tonik", "Digital bank", "USD/PHP")
    )
}
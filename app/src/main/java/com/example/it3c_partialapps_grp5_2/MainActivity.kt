package com.example.it3c_partialapps_grp5_2

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.it3c_partialapps_grp5_2.databinding.ActivityMainBinding
import com.example.it3c_partialapps_grp5_2.db.AppDatabase
import com.example.it3c_partialapps_grp5_2.db.defaultDate.DBViewModelDefaultDate
import com.example.it3c_partialapps_grp5_2.db.defaultDate.DBViewModelFactoryDefaultDate
import com.example.it3c_partialapps_grp5_2.db.defaultDate.EntityDefaultDate
import com.example.it3c_partialapps_grp5_2.db.feb0122.DBViewModelFactoryFeb0122
import com.example.it3c_partialapps_grp5_2.db.feb0122.DBViewModelFeb0122
import com.example.it3c_partialapps_grp5_2.db.feb0122.EntityFeb0122
import com.example.it3c_partialapps_grp5_2.db.feb0123.DBViewModelFactoryFeb0123
import com.example.it3c_partialapps_grp5_2.db.feb0123.DBViewModelFeb0123
import com.example.it3c_partialapps_grp5_2.db.feb0123.EntityFeb0123
import com.example.it3c_partialapps_grp5_2.db.jan0122.DBViewModelFactoryJan0122
import com.example.it3c_partialapps_grp5_2.db.jan0122.DBViewModelJan0122
import com.example.it3c_partialapps_grp5_2.db.jan0122.EntityJan0122
import com.example.it3c_partialapps_grp5_2.db.jan0123.DBViewModelFactoryJan0123
import com.example.it3c_partialapps_grp5_2.db.jan0123.DBViewModelJan0123
import com.example.it3c_partialapps_grp5_2.db.jan0123.EntityJan0123
import com.example.it3c_partialapps_grp5_2.model.HomeListModel
import com.example.it3c_partialapps_grp5_2.utils.ListItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dbViewModelJan0122: DBViewModelJan0122
    private lateinit var dbViewModelJan0123: DBViewModelJan0123
    private lateinit var dbViewModelFeb0122: DBViewModelFeb0122
    private lateinit var dbViewModelFeb0123: DBViewModelFeb0123
    private lateinit var dbViewModelDefaultDate: DBViewModelDefaultDate
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: Editor
    var arrDefaultDate: Array<Array<HomeListModel>> = Array(10) { Array(5) { HomeListModel("", "", "", "", "", Uri.parse("")) } }
    var arrJan0122: Array<Array<HomeListModel>> = Array(10) { Array(5) { HomeListModel("", "", "", "", "", Uri.parse("")) } }
    var arrJan0123: Array<Array<HomeListModel>> = Array(10) { Array(5) { HomeListModel("", "", "", "", "", Uri.parse("")) } }
    var arrFeb0122: Array<Array<HomeListModel>> = Array(10) { Array(5) { HomeListModel("", "", "", "", "", Uri.parse("")) } }
    var arrFeb0123: Array<Array<HomeListModel>> = Array(10) { Array(5) { HomeListModel("", "", "", "", "", Uri.parse("")) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("SP_dataInput_counter", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        // Initializing ViewModels
        dbViewModelJan0122 = ViewModelProvider(this@MainActivity, DBViewModelFactoryJan0122(
            AppDatabase.getInstance(application).daoJan0122())
        )[DBViewModelJan0122::class.java]
        dbViewModelJan0123 = ViewModelProvider(this@MainActivity, DBViewModelFactoryJan0123(
            AppDatabase.getInstance(application).daoJan0123())
        )[DBViewModelJan0123::class.java]
        dbViewModelFeb0122 = ViewModelProvider(this@MainActivity, DBViewModelFactoryFeb0122(
            AppDatabase.getInstance(application).daoFeb0122())
        )[DBViewModelFeb0122::class.java]
        dbViewModelFeb0123 = ViewModelProvider(this@MainActivity, DBViewModelFactoryFeb0123(
            AppDatabase.getInstance(application).daoFeb0123())
        )[DBViewModelFeb0123::class.java]
        dbViewModelDefaultDate = ViewModelProvider(this@MainActivity, DBViewModelFactoryDefaultDate(
            AppDatabase.getInstance(application).daoDefaultDate())
        )[DBViewModelDefaultDate::class.java]

        for (i in 0..9) {
            arrDefaultDate[i][0] = ListItem.listForHomeListAdapterJuly022023[i]
            arrJan0122[i][0] = ListItem.listForHomeListAdapterJanuary012022[i]
            arrJan0123[i][0] = ListItem.listForHomeListAdapterJanuary012023[i]
            arrFeb0122[i][0] = ListItem.listForHomeListAdapterFebruary012022[i]
            arrFeb0123[i][0] = ListItem.listForHomeListAdapterFebruary012023[i]
        }

        //  DB input
//        editor.clear().commit()
        val spValueCounter: Int = sharedPreferences.getInt("spCounter", 0)
        if (spValueCounter == 0) {
            CoroutineScope(Dispatchers.IO).launch {
                insertDataToDB()
            }
        }

        editor.apply {
            putInt("spCounter", spValueCounter + 1)
            commit()
        }

        // BottomNavigationView and NavController configuration
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_records, R.id.navigation_accounts, R.id.navigation_history
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    private fun insertDataToDB() {
        val localListItem: ListItem = ListItem

        //  Default date
        for (index in localListItem.listForHomeListAdapterJuly022023.indices) {
            val item = localListItem.listForHomeListAdapterJuly022023[index]

            dbViewModelDefaultDate.insertEntityFromVM(
                EntityDefaultDate(
                    0,
                    item.transactionProduct,
                    item.transactionType,
                    item.transactionAmount,
                    item.transactionCashback,
                    item.transactionDate
                )
            )
        }
        //  Jan. 01, 2022
        for (index in localListItem.listForHomeListAdapterJanuary012022.indices) {
            val item = localListItem.listForHomeListAdapterJanuary012022[index]

            dbViewModelJan0122.insertEntityFromVM(
                EntityJan0122(
                    0,
                    item.transactionProduct,
                    item.transactionType,
                    item.transactionAmount,
                    item.transactionCashback,
                    item.transactionDate
                )
            )
        }
        //  Jan. 01, 2023
        for (index in localListItem.listForHomeListAdapterJanuary012023.indices) {
            val item = localListItem.listForHomeListAdapterJanuary012023[index]

            dbViewModelJan0123.insertEntityFromVM(
                EntityJan0123(
                    0,
                    item.transactionProduct,
                    item.transactionType,
                    item.transactionAmount,
                    item.transactionCashback,
                    item.transactionDate
                )
            )
        }
        //  Feb. 01, 2022
        for (index in localListItem.listForHomeListAdapterFebruary012022.indices) {
            val item = localListItem.listForHomeListAdapterFebruary012022[index]

            dbViewModelFeb0122.insertEntityFromVM(
                EntityFeb0122(
                    0,
                    item.transactionProduct,
                    item.transactionType,
                    item.transactionAmount,
                    item.transactionCashback,
                    item.transactionDate
                )
            )
        }
        //  Feb. 01, 2023
        for (index in localListItem.listForHomeListAdapterFebruary012023.indices) {
            val item = localListItem.listForHomeListAdapterFebruary012023[index]

            dbViewModelFeb0123.insertEntityFromVM(
                EntityFeb0123(
                    0,
                    item.transactionProduct,
                    item.transactionType,
                    item.transactionAmount,
                    item.transactionCashback,
                    item.transactionDate
                )
            )
        }
    }
}
package com.example.it3c_partialapps_grp5_2.ui.home

import android.Manifest
import android.app.ActivityManager
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.text.color
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.it3c_partialapps_grp5_2.R
import com.example.it3c_partialapps_grp5_2.adapter.HomeListAdapter
import com.example.it3c_partialapps_grp5_2.databinding.FragmentHomeBinding
import com.example.it3c_partialapps_grp5_2.db.AppDatabase
import com.example.it3c_partialapps_grp5_2.db.defaultDate.DBViewModelDefaultDate
import com.example.it3c_partialapps_grp5_2.db.defaultDate.DBViewModelFactoryDefaultDate
import com.example.it3c_partialapps_grp5_2.db.defaultDate.EntityDefaultDate
import com.example.it3c_partialapps_grp5_2.db.feb0122.DBViewModelFactoryFeb0122
import com.example.it3c_partialapps_grp5_2.db.feb0122.DBViewModelFeb0122
import com.example.it3c_partialapps_grp5_2.db.feb0123.DBViewModelFactoryFeb0123
import com.example.it3c_partialapps_grp5_2.db.feb0123.DBViewModelFeb0123
import com.example.it3c_partialapps_grp5_2.db.jan0122.DBViewModelFactoryJan0122
import com.example.it3c_partialapps_grp5_2.db.jan0122.DBViewModelJan0122
import com.example.it3c_partialapps_grp5_2.db.jan0123.DBViewModelFactoryJan0123
import com.example.it3c_partialapps_grp5_2.db.jan0123.DBViewModelJan0123
import com.example.it3c_partialapps_grp5_2.utils.ListItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import java.util.Calendar
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.system.exitProcess
import kotlin.text.StringBuilder

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var chosenDate: StringBuilder
    private lateinit var homeViewModel: HomeViewModel
    private val calendar: Calendar = Calendar.getInstance()
    private var calendarYear: Int = calendar.get(Calendar.YEAR)
    private var calendarMonth: Int = calendar.get(Calendar.MONTH)
    private var calendarDay: Int = calendar.get(Calendar.DAY_OF_MONTH)
    private var totalExpensesFromRV: Double = 0.0
    private var totalIncomeFromRV: Double = 0.0
    private lateinit var decimalFormat: DecimalFormat
    private var PERMISSION_CODE = 101
    private lateinit var dbViewModelJan0122: DBViewModelJan0122
    private lateinit var dbViewModelJan0123: DBViewModelJan0123
    private lateinit var dbViewModelFeb0122: DBViewModelFeb0122
    private lateinit var dbViewModelFeb0123: DBViewModelFeb0123
    private lateinit var dbViewModelDefaultDate: DBViewModelDefaultDate
    private var chosenDateForPDF: String = ""

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        setHasOptionsMenu(true)
        chosenDate = StringBuilder()
        decimalFormat = DecimalFormat(resources.getString(R.string.decimal_format_format))
        dbViewModelJan0122 = ViewModelProvider(requireActivity(), DBViewModelFactoryJan0122(
            AppDatabase.getInstance(requireContext()).daoJan0122())
        )[DBViewModelJan0122::class.java]
        dbViewModelJan0123 = ViewModelProvider(requireActivity(), DBViewModelFactoryJan0123(
            AppDatabase.getInstance(requireContext()).daoJan0123())
        )[DBViewModelJan0123::class.java]
        dbViewModelFeb0122 = ViewModelProvider(requireActivity(), DBViewModelFactoryFeb0122(
            AppDatabase.getInstance(requireContext()).daoFeb0122())
        )[DBViewModelFeb0122::class.java]
        dbViewModelFeb0123 = ViewModelProvider(requireActivity(), DBViewModelFactoryFeb0123(
            AppDatabase.getInstance(requireContext()).daoFeb0123())
        )[DBViewModelFeb0123::class.java]
        dbViewModelDefaultDate = ViewModelProvider(requireActivity(), DBViewModelFactoryDefaultDate(
            AppDatabase.getInstance(requireContext()).daoDefaultDate())
        )[DBViewModelDefaultDate::class.java]

        ListItem.fillArrayExpenses()
        ListItem.fillArrayIncome()

        functionsConfiguration()

        return root
    }

    private fun functionsConfiguration() {
        _binding?.apply {
            tvTopHeader.text = dateChooserFormat()
            tvTopHeaderPDF.text = pdfTextFormat()

            val initialAdapter: HomeListAdapter = HomeListAdapter(ListItem.listForHomeListAdapterJuly022023)
            rvHome.adapter = initialAdapter
            settingIncomeAndExpensesFunction(initialAdapter)

            cvDatePicker.setOnClickListener {
                setDate()
            }
            cvGeneratePDF.setOnClickListener {
                // on below line we are checking permission
                if (checkPermissions()) {
                    // if permission is granted we are displaying a toast message.
                    Toast.makeText(requireContext(), "Permissions Granted..", Toast.LENGTH_SHORT).show()
                    PDFGenerator(requireContext(), requireActivity(), this@HomeFragment, chosenDateForPDF).getPDF()
                } else {
                    // if the permission is not granted
                    // we are calling request permission method.
                    requestPermission()
                }
            }

            homeViewModel.chosenDateLiveData.observe(viewLifecycleOwner) { date ->
                chosenDateForPDF = date
                val adapter = when (date) {
                    "Jan 01 2022" -> HomeListAdapter(ListItem.listForHomeListAdapterJanuary012022)
                    "Feb 01 2022" -> HomeListAdapter(ListItem.listForHomeListAdapterFebruary012022)
                    "Jan 01 2023" -> HomeListAdapter(ListItem.listForHomeListAdapterJanuary012023)
                    "Feb 01 2023" -> HomeListAdapter(ListItem.listForHomeListAdapterFebruary012023)
                    else -> HomeListAdapter(ListItem.listForHomeListAdapterJuly022023)
                }
                settingIncomeAndExpensesFunction(adapter)

                rvHome.adapter = adapter
            }

            fabExit.setOnClickListener {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Confirmation")
                builder.setMessage("Are you sure you want to exit the program?")

                builder.setPositiveButton(android.R.string.yes) { _, _ ->
                    // Get the activity manager
                    val activityManager = requireActivity().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
                    // Kill the background processes of the app
                    activityManager.killBackgroundProcesses("com.example.it3c_partialapps_grp5_2")
                    // Exit the application
                    exitProcess(0)
                }

                builder.setNegativeButton(android.R.string.cancel) { _, _ -> }
                builder.show()
            }
        }
    }

    private fun checkPermissions(): Boolean {
        // on below line we are creating a variable for both of our permissions.

        // on below line we are creating a variable for
        // writing to external storage permission
        val writeStoragePermission = ContextCompat.checkSelfPermission(
            requireContext().applicationContext,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        // on below line we are creating a variable
        // for reading external storage permission
        val readStoragePermission = ContextCompat.checkSelfPermission(
            requireContext().applicationContext,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )

        // on below line we are returning true if both the
        // permissions are granted and returning false
        // if permissions are not granted.
        return writeStoragePermission == PackageManager.PERMISSION_GRANTED
                && readStoragePermission == PackageManager.PERMISSION_GRANTED
    }

    // on below line we are creating a function to request permission.
    private fun requestPermission() {

        // on below line we are requesting read and write to
        // storage permission for our application.
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ), PERMISSION_CODE
        )
    }

    private fun settingIncomeAndExpensesFunction(adapter: HomeListAdapter) {
        for (i in 0 until adapter.itemCount) {
            totalExpensesFromRV += adapter.getAmountAtPosition(i).removeRange(0, 1).replace(",", "").toDouble()
            totalIncomeFromRV += adapter.getCashbackAtPosition(i).removeRange(0, 1).replace(",", "").toDouble()
        }
        binding.apply {
            totalExpensesFromRV = 0.0
            totalIncomeFromRV = 0.0
        }
    }

    private fun dateChooserFormat(): SpannableStringBuilder {
        return SpannableStringBuilder()
            .append("CLick ")
            .color(ContextCompat.getColor(requireContext(), R.color.theme_color_brown)) { append("HERE") }
            .append(" to adjust the date")
    }

    private fun pdfTextFormat(): SpannableStringBuilder {
        return SpannableStringBuilder()
            .append("Click ")
            .color(ContextCompat.getColor(requireContext(), R.color.theme_color_brown)) { append("HERE") }
            .append(" to print the PDF")
    }

    private fun setDate() {
        val datePickerDialog: DatePickerDialog = DatePickerDialog(
            requireContext(), DatePickerDialog.OnDateSetListener{ _, year, monthOfYear, dayOfMonth ->
                val returnDate = "${monthOfYear + 1} $dayOfMonth $year"
                val date = StringHelper.parseDate(
                    "MM dd yyyy",
                    "MM/dd/yyyy",
                    returnDate
                )
                _binding?.apply {
                    chosenDate.setLength(0)
                    chosenDate.append(StringHelper.parseDate("MM/dd/yyyy","MMM dd yyyy",date))
                    homeViewModel.chosenDateLiveData.value = chosenDate.toString()
                }
                Snackbar.make(requireView(), "Displayed date has been updated successfully",
                    Snackbar.ANIMATION_MODE_FADE and Snackbar.LENGTH_LONG).setAction("Action", null).show()
            },calendarYear-30, calendarMonth, calendarDay
        )
        datePickerDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @Deprecated("Deprecated in Java", ReplaceWith("menu.clear()"))
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
    }
}
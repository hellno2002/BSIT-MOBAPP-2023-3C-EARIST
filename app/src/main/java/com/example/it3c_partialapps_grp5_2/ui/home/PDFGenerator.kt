package com.example.it3c_partialapps_grp5_2.ui.home

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import com.example.it3c_partialapps_grp5_2.R
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class PDFGenerator(
    private val context: Context,
    private val viewModelStoreOwner:
    ViewModelStoreOwner,
    private val homeFragment: HomeFragment,
    private val chosenDateFromHomeFragment: String
    ) : AppCompatActivity() {
    // declaring width and height
    // for our PDF file.
    private var pageHeight = 1120
    private var pageWidth = 792

    // creating a bitmap variable
    // for storing our images
    private lateinit var bmp: Bitmap
    private lateinit var scaledbmp: Bitmap

    private lateinit var dbViewModelJan0122: DBViewModelJan0122
    private lateinit var dbViewModelJan0123: DBViewModelJan0123
    private lateinit var dbViewModelFeb0122: DBViewModelFeb0122
    private lateinit var dbViewModelFeb0123: DBViewModelFeb0123
    private lateinit var dbViewModelDefaultDate: DBViewModelDefaultDate

    // on below line we are creating a
    // constant code for runtime permissions.

    fun getPDF() {
        // on below line we are initializing our bitmap and scaled bitmap.
        bmp = BitmapFactory.decodeResource(context.resources, R.drawable.img)
        scaledbmp = Bitmap.createScaledBitmap(bmp, 140, 140, false)

        dbViewModelJan0122 = ViewModelProvider(viewModelStoreOwner, DBViewModelFactoryJan0122(
            AppDatabase.getInstance(context).daoJan0122())
        )[DBViewModelJan0122::class.java]
        dbViewModelJan0123 = ViewModelProvider(viewModelStoreOwner, DBViewModelFactoryJan0123(
            AppDatabase.getInstance(context).daoJan0123())
        )[DBViewModelJan0123::class.java]
        dbViewModelFeb0122 = ViewModelProvider(viewModelStoreOwner, DBViewModelFactoryFeb0122(
            AppDatabase.getInstance(context).daoFeb0122())
        )[DBViewModelFeb0122::class.java]
        dbViewModelFeb0123 = ViewModelProvider(viewModelStoreOwner, DBViewModelFactoryFeb0123(
            AppDatabase.getInstance(context).daoFeb0123())
        )[DBViewModelFeb0123::class.java]
        dbViewModelDefaultDate = ViewModelProvider(viewModelStoreOwner, DBViewModelFactoryDefaultDate(
            AppDatabase.getInstance(context).daoDefaultDate())
        )[DBViewModelDefaultDate::class.java]

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            // on below line we are calling generate
            // PDF method to generate our PDF file.
            generatePDF()
        }
    }

    private fun generatePDF() {
        // creating an object variable for our PDF document
        val pdfDocument: PdfDocument = PdfDocument()

        // Two variables for paint: imagePaint for drawing shapes and textPaint for adding text in our PDF file
        val imagePaint: Paint = Paint()
        val textPaint: Paint = Paint()

        // Adding page info to our PDF file, specifying pageWidth, pageHeight, and number of pages
        val myPageInfo: PdfDocument.PageInfo? = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 3).create()

        // Starting a new page in the PDF document
        val myPage: PdfDocument.Page = pdfDocument.startPage(myPageInfo)

        // Creating a canvas object from our PDF page
        val canvas: Canvas = myPage.canvas

        // Setting typeface for our text in the PDF file
        textPaint.typeface = Typeface.create(ResourcesCompat.getFont(context, R.font.acme), Typeface.NORMAL)

        // Setting text size for our text in the PDF file
        textPaint.textSize = 30F

        // Setting color for our text in the PDF file
        textPaint.color = ContextCompat.getColor(context, R.color.black)

        // Aligning the text and image
        val xPos: Float = (canvas.width / 2).toFloat()
        val yPos: Int = ((canvas.height / 2) - ((textPaint.descent() + textPaint.ascent()) / 2)).toInt()

        // Drawing the image on the PDF file
        canvas.drawBitmap(scaledbmp, xPos - (scaledbmp.width / 2), 20F, imagePaint)

        // Drawing the main title and subtitle on the PDF file
        textPaint.textAlign = Paint.Align.CENTER
        canvas.drawText("EXPENSE FLOW", xPos, 190F, textPaint)
        canvas.drawText("Your reliable financial record-keeping solution", xPos, 240F, textPaint)

        // Setting the text alignment to left for the body
        textPaint.textAlign = Paint.Align.LEFT

        // Body
        textPaint.typeface = Typeface.create(ResourcesCompat.getFont(context, R.font.acme), Typeface.NORMAL)
        textPaint.color = ContextCompat.getColor(context, R.color.black)
        textPaint.textSize = 15F

        var verticalSpacing: Float = 330F
        val maxVerticalSpacing: Float = 900F  // Adjust this threshold as needed
        val columnSpacing: Float = 250F
        var currentColumn = 1
        var tempXPos: Float = 90F

        // Fetching data using a coroutine
        lifecycleScope.launch {
            when (chosenDateFromHomeFragment) {
                "Jan 01 2022" -> {
                    val data = suspendCoroutine<List<EntityJan0122>> { continuation ->
                        dbViewModelJan0122.getAllEntityFromVM.observe(homeFragment.viewLifecycleOwner, Observer {
                            continuation.resume(it)
                        })
                    }
                    // Processing the loaded data
                    for (i in 0..9) {
                        val temp = data[i]

                        verticalSpacing += 25

                        if (verticalSpacing > maxVerticalSpacing) {
                            // Start a new column
                            verticalSpacing = 350F
                            tempXPos += columnSpacing
                            currentColumn++
                        }

                        canvas.drawText("Product: ${temp.product_name}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Transaction type: ${temp.product_type}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Amount: ${temp.product_amount}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("RNI: ${temp.product_rni}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Date: ${temp.product_date}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 35
                    }
                }
                "Feb 01 2022" -> {
                    val data = suspendCoroutine<List<EntityFeb0122>> { continuation ->
                        dbViewModelFeb0122.getAllEntityFromVM.observe(homeFragment.viewLifecycleOwner, Observer {
                            continuation.resume(it)
                        })
                    }
                    // Processing the loaded data
                    for (i in 0..9) {
                        val temp = data[i]

                        verticalSpacing += 25

                        if (verticalSpacing > maxVerticalSpacing) {
                            // Start a new column
                            verticalSpacing = 350F
                            tempXPos += columnSpacing
                            currentColumn++
                        }

                        canvas.drawText("Product: ${temp.product_name}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Transaction type: ${temp.product_type}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Amount: ${temp.product_amount}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("RNI: ${temp.product_rni}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Date: ${temp.product_date}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 35
                    }
                }
                "Jan 01 2023" -> {
                    val data = suspendCoroutine<List<EntityJan0123>> { continuation ->
                        dbViewModelJan0123.getAllEntityFromVM.observe(homeFragment.viewLifecycleOwner, Observer {
                            continuation.resume(it)
                        })
                    }
                    // Processing the loaded data
                    for (i in 0..9) {
                        val temp = data[i]

                        verticalSpacing += 25

                        if (verticalSpacing > maxVerticalSpacing) {
                            // Start a new column
                            verticalSpacing = 350F
                            tempXPos += columnSpacing
                            currentColumn++
                        }

                        canvas.drawText("Product: ${temp.product_name}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Transaction type: ${temp.product_type}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Amount: ${temp.product_amount}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("RNI: ${temp.product_rni}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Date: ${temp.product_date}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 35
                    }
                }
                "Feb 01 2023" -> {
                    val data = suspendCoroutine<List<EntityFeb0123>> { continuation ->
                        dbViewModelFeb0123.getAllEntityFromVM.observe(homeFragment.viewLifecycleOwner, Observer {
                            continuation.resume(it)
                        })
                    }
                    // Processing the loaded data
                    for (i in 0..9) {
                        val temp = data[i]

                        verticalSpacing += 25

                        if (verticalSpacing > maxVerticalSpacing) {
                            // Start a new column
                            verticalSpacing = 350F
                            tempXPos += columnSpacing
                            currentColumn++
                        }

                        canvas.drawText("Product: ${temp.product_name}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Transaction type: ${temp.product_type}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Amount: ${temp.product_amount}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("RNI: ${temp.product_rni}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Date: ${temp.product_date}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 35
                    }
                }
                else -> {
                    val data = suspendCoroutine<List<EntityDefaultDate>> { continuation ->
                        dbViewModelDefaultDate.getAllEntityFromVM.observe(homeFragment.viewLifecycleOwner, Observer {
                            continuation.resume(it)
                        })
                    }
                    // Processing the loaded data
                    for (i in 0..9) {
                        val temp = data[i]

                        verticalSpacing += 25

                        if (verticalSpacing > maxVerticalSpacing) {
                            // Start a new column
                            verticalSpacing = 350F
                            tempXPos += columnSpacing
                            currentColumn++
                        }

                        canvas.drawText("Product: ${temp.product_name}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Transaction type: ${temp.product_type}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Amount: ${temp.product_amount}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("RNI: ${temp.product_rni}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 25
                        canvas.drawText("Date: ${temp.product_date}", tempXPos, verticalSpacing, textPaint)
                        verticalSpacing += 35
                    }
                }
            }

            // Finishing the PDF page
            pdfDocument.finishPage(myPage)

            // Setting the name and path for the PDF file
            val file: File = File(Environment.getExternalStorageDirectory(), "report.pdf")

            try {
                // Writing the PDF file
                withContext(Dispatchers.IO) {
                    pdfDocument.writeTo(FileOutputStream(file))
                }

                // Displaying a toast message when the PDF file is generated successfully
                Toast.makeText(context.applicationContext, "PDF file generated..", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                // Handling error and displaying a toast message when the PDF generation fails
                e.printStackTrace()
                Log.i("MyTag", e.printStackTrace().toString())
                Toast.makeText(context.applicationContext, "Failed to generate PDF file..", Toast.LENGTH_SHORT).show()
            }

            // Closing the PDF document
            pdfDocument.close()
        }
    }
}
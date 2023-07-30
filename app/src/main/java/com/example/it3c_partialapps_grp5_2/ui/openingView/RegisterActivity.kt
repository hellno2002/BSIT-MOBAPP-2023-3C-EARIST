package com.example.it3c_partialapps_grp5_2.ui.openingView

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.SpannableStringBuilder
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.color
import com.example.it3c_partialapps_grp5_2.R
import com.example.it3c_partialapps_grp5_2.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class RegisterActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityRegisterBinding
    private lateinit var bottomSheetFragment: AppBottomSheetFragment
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportActionBar?.hide()
        bottomSheetFragment = AppBottomSheetFragment()
        sharedPreferences = getSharedPreferences("SharedPreferences_AppBottomSheetFragment", Context.MODE_PRIVATE)
        firebaseAuth = FirebaseAuth.getInstance()

        _binding.apply {
            val codeColor: Int = ContextCompat.getColor(this@RegisterActivity, R.color.theme_color_brown)
            val textFromTvConsent = SpannableStringBuilder()
                .append("Upon registration, you will be required to review our ")
                .color(codeColor) { append("Terms of Service") }
                .append(" and ")
                .color(codeColor) { append("Privacy Policy.")}
            tvConsent.text = textFromTvConsent

            cbSP2.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    etPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    etConfirmPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                } else {
                    etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    etConfirmPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }
                etPassword.typeface = ResourcesCompat.getFont(this@RegisterActivity, R.font.acme)
                etConfirmPassword.typeface = ResourcesCompat.getFont(this@RegisterActivity, R.font.acme)
            }

            btnRegisterLayoutRegister.setOnClickListener {
                if (!(etUsername.text.toString() == "" || etPassword.text.toString() == "" || etConfirmPassword.text.toString() == "")) {
                    if (etPassword.text.toString() != etConfirmPassword.text.toString()) {
                        Snackbar.make(view, "Password does not match with confirm password", Snackbar.LENGTH_LONG.and(Snackbar.ANIMATION_MODE_FADE)).setAction("Action", null).show()
                        clearEntries()
                    }
                    else {
                        when (sharedPreferences.getInt("ConsentVerification", 0)) {
                            0 -> {
                                _binding.apply {
                                    val username: String = etUsername.text.toString()
                                    val password: String = etPassword.text.toString()

                                    CoroutineScope(Dispatchers.IO).launch {
                                        firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener {
                                            if (it.isSuccessful) bottomSheetFragment.show(supportFragmentManager, "BottomSheetFragment_Consent")
                                            else {
                                                try {
                                                    val exceptionMessage: String = it.exception.toString()
                                                    val scLocation = exceptionMessage.indexOf(":")
                                                    val finalString = exceptionMessage.substring(scLocation + 1, exceptionMessage.length)

                                                    Snackbar.make(view, finalString, Snackbar.LENGTH_LONG.and(Snackbar.ANIMATION_MODE_FADE)).setAction("Action", null).show()
                                                    clearEntries()
                                                    etUsername.setText("")
                                                } catch (ignored: Exception) {}
                                            }
                                        }
                                    }
                                }
                            }
                            else -> { sharedPreferences.edit().remove("ConsentVerification").apply() }
                        }
                    }
                } else { Snackbar.make(view, "Please fill all the fields", Snackbar.LENGTH_LONG.and(Snackbar.ANIMATION_MODE_FADE)).setAction("Action", null).show() }
            }
            fbtnBackFromRegister.setOnClickListener { startActivity(Intent(this@RegisterActivity, LoginActivity::class.java)) }
        }
    }

    private fun clearEntries() {
        _binding.apply {
            etPassword.setText("")
            etConfirmPassword.setText("")
        }
    }
}
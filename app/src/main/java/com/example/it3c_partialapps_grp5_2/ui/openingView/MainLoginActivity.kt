package com.example.it3c_partialapps_grp5_2.ui.openingView

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentManager
import com.example.it3c_partialapps_grp5_2.MainActivity
import com.example.it3c_partialapps_grp5_2.R
import com.example.it3c_partialapps_grp5_2.databinding.ActivityMainLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainLoginActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var loginDialogFragment: LoginDialogFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        loginDialogFragment = LoginDialogFragment()
        supportActionBar?.hide()

        _binding.apply {
            fbtnBackFromLogin.setOnClickListener {
                startActivity(Intent(this@MainLoginActivity, LoginActivity::class.java))
            }
            cbSP.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) etPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                else etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                etPassword.typeface = ResourcesCompat.getFont(this@MainLoginActivity, R.font.acme)
            }

            btnLoginLayoutLogin.setOnClickListener {
                if (!(etUsername.text.toString() == "" || etPassword.text.toString() == "")) {
                    val inputtedUsername: String = etUsername.text.toString()
                    val inputtedPassword: String = etPassword.text.toString()

                    CoroutineScope(Dispatchers.IO).launch {
                        loginDialogFragment.show(supportFragmentManager, loginDialogFragment.tag)
                        firebaseAuth.signInWithEmailAndPassword(inputtedUsername, inputtedPassword).addOnCompleteListener {
                            loginDialogFragment.dismiss()
                            if (it.isSuccessful) startActivity(Intent(this@MainLoginActivity, MainActivity::class.java))
                            else {
                                try {
                                    val exceptionMessage: String = it.exception.toString()
                                    val scLocation = exceptionMessage.indexOf(":")
                                    val finalString = exceptionMessage.substring(scLocation + 1, exceptionMessage.length)

                                    Snackbar.make(view, finalString, Snackbar.LENGTH_LONG.and(Snackbar.ANIMATION_MODE_FADE)).setAction("Action", null).show()
                                    clearEntries()
                                } catch (ignored: Exception) {}
                            }
                        }
                    }
                }
                else { Snackbar.make(view, "Please fill all the fields", Snackbar.LENGTH_LONG.and(Snackbar.ANIMATION_MODE_FADE)).setAction("Action", null).show() }
            }
        }
    }

    private fun clearEntries() {
        _binding.apply {
            etPassword.setText("")
            etUsername.setText("")
        }
    }
}
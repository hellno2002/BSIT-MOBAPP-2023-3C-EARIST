package com.example.it3c_partialapps_grp5_2.ui.openingView

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.it3c_partialapps_grp5_2.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportActionBar?.hide()
        sharedPreferences = getSharedPreferences("SharedPreferences_AppBottomSheetFragment", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.apply {
            putInt("ConsentVerification", 0)
            commit()
        }

        _binding.apply {
            btnRegister.setOnClickListener { startActivity(Intent(this@LoginActivity, RegisterActivity::class.java)) }
            btnLogin.setOnClickListener { startActivity(Intent(this@LoginActivity, MainLoginActivity::class.java)) }
        }
    }
}
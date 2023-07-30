package com.example.it3c_partialapps_grp5_2.ui.openingView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.it3c_partialapps_grp5_2.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var _binding: ActivitySplashScreenBinding

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportActionBar?.hide()

        GlobalScope.launch(Dispatchers.Main) {
            delay(3000)
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
        }
    }
}
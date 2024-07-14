package com.example.thereafter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.window.SplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, SplashScreen())
            commit()
        }
    }
}
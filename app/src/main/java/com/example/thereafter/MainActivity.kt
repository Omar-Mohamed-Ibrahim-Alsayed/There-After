package com.example.thereafter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thereafter.fragments.Splash

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, Splash())
            commit()
        }
    }
}

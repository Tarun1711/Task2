package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = Fragment1()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout1, fragment1)
            .commit()

        val fragment2 = Fragment2()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout2, fragment2)
            .commit()

    }
}
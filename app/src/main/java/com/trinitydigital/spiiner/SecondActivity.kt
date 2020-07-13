package com.trinitydigital.spiiner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val data = intent.getParcelableExtra<UserData>("data")

        Toast.makeText(this, data?.email, Toast.LENGTH_LONG).show()
    }
}
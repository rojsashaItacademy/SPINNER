package com.trinitydigital.spiiner

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var btnSend: Button? = null
    private var spAnimals: Spinner? = null
    private var isFirst = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setupListeners()
        setupSpinner()
    }

    private fun initView() {
        btnSend = findViewById(R.id.btnSend)
        spAnimals = findViewById(R.id.spAnimals)
    }

    private fun setupListeners() {
        btnSend?.setOnClickListener {
            goToSecondActivity()
        }

        spAnimals?.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position != 0) {
                    val selectedItem = parent.getItemAtPosition(position).toString()
                    Toast.makeText(applicationContext, "Вы выбрали $selectedItem", Toast.LENGTH_LONG).show()
                }

                isFirst = true
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setupSpinner() {
        val adapter =
                ArrayAdapter.createFromResource(this, R.array.animals, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spAnimals?.adapter = adapter
    }

    private fun goToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        val dataClass = UserData("Aeaweawe", "asdasdsad",
                "adasdasd", "adasdasd", 12, "adasdsad", "adsadsasdad")
        dataClass.email = "no mail"
        dataClass.password = "no pass"
        intent.putExtra("data", dataClass)
        startActivity(intent)
    }
}
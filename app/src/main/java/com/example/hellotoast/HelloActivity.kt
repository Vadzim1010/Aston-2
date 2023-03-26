package com.example.hellotoast

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HelloActivity : AppCompatActivity() {

    private var helloTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)


        helloTextView = findViewById(R.id.hello_string)

        val count = intent.extras?.getInt("KEY").toString()

        helloTextView?.text = getString(R.string.hello_title, count)
    }
}
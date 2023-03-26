package com.example.hellotoast

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var sayHelloButton: Button? = null
    private var countButton: Button? = null
    private var countTextView: TextView? = null
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setDefaultValue()
        count()

        sayHelloButton?.setOnClickListener {
            val extras = Bundle()
            extras.putInt("KEY", count)
            val intent = Intent(this, HelloActivity().javaClass)
            intent.putExtras(extras)
            startActivity(intent)
        }
    }

    private fun initView() {
        countButton = findViewById(R.id.count_button)
        countTextView = findViewById(R.id.counter_text_view)
        sayHelloButton = findViewById(R.id.say_hello_button)
    }

    private fun setDefaultValue() {
        countTextView?.text = count.toString()
    }

    private fun count() {
        countButton?.setOnClickListener {
            count += 1
            countTextView?.text = count.toString()
        }
    }
}
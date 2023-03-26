package com.example.hellotoast

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var countButton: Button? = null
    private var countTextView: TextView? = null
    private var editText: EditText? = null
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setValue(savedInstanceState)
        count()
    }

    private fun initView() {
        countButton = findViewById(R.id.count_button)
        countTextView = findViewById(R.id.counter_text_view)
        editText = findViewById(R.id.edit_text)
    }

    private fun setValue(savedInstanceState: Bundle?) {
        val currentCount = savedInstanceState?.getInt(KEY_INT)
        val currentString = savedInstanceState?.getString(KEY_STRING)

        countTextView?.text = currentCount?.toString() ?: count.toString()
        count = currentCount ?: 0

        editText?.setText(currentString)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_INT, count)
        outState.putString(KEY_STRING, editText?.text.toString())
    }

    private fun count() {
        countButton?.setOnClickListener {
            count += 1
            countTextView?.text = count.toString()
        }
    }

    companion object {
        private const val KEY_INT = "key_int"
        private const val KEY_STRING = "key_string"
    }
}
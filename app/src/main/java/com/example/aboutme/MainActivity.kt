package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener{addNickname(it)}
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{updateNickname(it)}
    }
    private fun addNickname(view: View){
        val editNickname = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editNickname.text
        editNickname.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun updateNickname(view: View){
        val editNickname = findViewById<EditText>(R.id.nickname_edit)
        findViewById<Button>(R.id.done_button).visibility = View.VISIBLE
        editNickname.visibility = View.VISIBLE
        editNickname.requestFocus()
        view.visibility = View.GONE

        // Hide the keyboard.
        val inputMethodManager: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editNickname, 0)
    }
}
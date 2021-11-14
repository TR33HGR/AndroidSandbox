package com.example.androidsandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val textView = findViewById<TextView>(R.id.textView)

        val url = "https://www.google.com"

        val stringRequest = StringRequest(Request.Method.GET, url, { response ->
            textView.text = "Response is: ${response.substring(0, 500)}"
        }, { textView.text = "That didn't work!" })
        MySingleton.getInstance(this).addToRequestQuese(stringRequest)
    }
}
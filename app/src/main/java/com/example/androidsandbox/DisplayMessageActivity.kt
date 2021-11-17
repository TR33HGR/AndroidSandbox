package com.example.androidsandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONObject

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val textView = findViewById<TextView>(R.id.textView)

        val data = PapagoRequestData("ko", "en", "만나서 반갑습니다.")
        Log.d(DEBUG, "%s".format(data.toString()))

        val request = PapagoJsonRequest(data, { response ->
            textView.text = "Response is: %s".format(response.toString())
        }, { error -> textView.text = "That didn't work! %s".format(error.toString()) })

        MySingleton.getInstance(this).addToRequestQuese(request)
    }
}
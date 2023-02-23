package com.example.jsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btn(view: View) {
        val queue = Volley.newRequestQueue(this)
        val url = "https://jsonplaceholder.typicode.com/posts"
                                                                                                                        //request a string response from the provided url
        val stringRequest = StringRequest(
            Request.Method.GET, url, { response ->
                val data = response.toString()
                val jArry = JSONArray(data)
                for (i in 0 until jArry.length()) {
                    val jObject = jArry.getJSONObject(i)
                    val userId = jObject.getInt("userId")
                    var id = jObject.getInt("id")
                    var title = jObject.getString("title")
                    var body = jObject.getString("body")
                    Log.e("userId", userId.toString())
                    Log.e("id", id.toString())
                    Log.e("title", title.toString())
                    Log.e("body", body.toString())
                }
            },
            { })
                                                                                    ///add the request to the requestQueue
    queue.add(stringRequest)
    }
}
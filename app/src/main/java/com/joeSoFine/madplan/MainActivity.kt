package com.joeSoFine.madplan

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.QuerySnapshot
import android.content.ContentValues.TAG

class MainActivity : AppCompatActivity() {
    lateinit var myContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myContainer = findViewById(R.id.linscroll)
        val edit = findViewById<Button>(R.id.button)

        createDayCard()

        readData(object: FireStoreCallback {
            override fun onCallback(value: List<String>) {
                Log.d("TAG", value.size.toString())
            }
        })



        edit.setOnClickListener {
            val intent = Intent(applicationContext, CreateDay::class.java)
            startActivity(intent)
        }


    }

    fun createDayCard() {
        var CardView: View = layoutInflater.inflate(R.layout.day_card_view, null, false)
        myContainer.addView(CardView)


    }
}
package com.example.madplan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    lateinit var myContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myContainer = findViewById(R.id.linscroll)
        val edit = findViewById<Button>(R.id.button)
        edit.setOnClickListener { createDayCard() }

    }

    fun createDayCard(){
        var CardView: View = layoutInflater.inflate(R.layout.day_card_view, null, false)
        myContainer.addView(CardView)


    }
}
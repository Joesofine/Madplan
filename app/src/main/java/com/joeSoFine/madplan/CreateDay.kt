package com.joeSoFine.madplan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CreateDay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_day)



        val save = findViewById<Button>(R.id.save)
        save.setOnClickListener {
            var newDay = Day(findViewById<Button>(R.id.day).text.toString(), findViewById<Button>(R.id.m1).text.toString(), findViewById<Button>(R.id.m2).text.toString(), findViewById<Button>(R.id.m3).text.toString())
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }
    }
}
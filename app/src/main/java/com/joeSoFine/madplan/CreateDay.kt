package com.joeSoFine.madplan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CreateDay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_day)



        val save = findViewById<Button>(R.id.save)
        save.setOnClickListener {
            var newDay = Day(findViewById<EditText>(R.id.day).text.toString(), findViewById<EditText>(R.id.m1).text.toString(), findViewById<EditText>(R.id.m2).text.toString(), findViewById<EditText>(R.id.m3).text.toString())
            uploadData("days", newDay)



            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }
    }
}
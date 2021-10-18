package com.joeSoFine.madplan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.content.ContentValues.TAG
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot

class MainActivity : AppCompatActivity() {
    lateinit var myContainer: LinearLayout
    val ref = "days"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myContainer = findViewById(R.id.linscroll)
        val edit = findViewById<Button>(R.id.button)

        FirebaseFirestore.getInstance().collection(ref).addSnapshotListener{ value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                return@addSnapshotListener
            }

            for (doc in value!!) {
                createDayCard(doc)
            }
            Log.d(TAG, value.size().toString())
        }


        /*readData(object: FireStoreCallback {
            override fun onCallback(value: List<String>) {
                Log.d(TAG, value.size.toString())
            }
        })



         */



        edit.setOnClickListener {
            val intent = Intent(applicationContext, CreateDay::class.java)
            startActivity(intent)
        }


    }

    fun createDayCard(document: QueryDocumentSnapshot) {
        var CardView: View = layoutInflater.inflate(R.layout.day_card_view, null, false)
        var dayName: TextView = CardView.findViewById(R.id.nameField)
        var morgen: TextView = CardView.findViewById(R.id.morgenmad)
        var frokost: TextView = CardView.findViewById(R.id.frokost)
        var aften: TextView = CardView.findViewById(R.id.aftensmad)
        var m1: TextView = CardView.findViewById(R.id.mellem1field)
        var m2: TextView = CardView.findViewById(R.id.mellem2field)

        dayName.text = document.getString("dayName")
        morgen.text = document.getString("breakfast")
        frokost.text = document.getString("lunch")
        aften.text = document.getString("dinner")
        m1.text = document.getString("snack1")
        m2.text = document.getString("snack2")

        myContainer.addView(CardView)
    }
}
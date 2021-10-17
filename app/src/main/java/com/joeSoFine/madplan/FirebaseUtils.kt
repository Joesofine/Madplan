package com.joeSoFine.madplan

import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.getField

class FirebaseUtils {
    val fireStoreDatabase = FirebaseFirestore.getInstance()
}


fun uploadData(collection: String, data: Day) {
        // use the add() method to create a document inside users collection
        FirebaseUtils().fireStoreDatabase.collection(collection)
            .add(data)
            .addOnSuccessListener {
                Log.d(TAG, "Added document with ID ${it.id}")
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error adding document $exception")
            }
}

fun readData(collection: String, listener: OnSuccessListener<QuerySnapshot>): ArrayList<String> {
    var arr: ArrayList<String> = ArrayList()

    FirebaseUtils().fireStoreDatabase.collection(collection)
        .get()
        .addOnSuccessListener { listener }
        .addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents $exception")
        }
    return arr
}
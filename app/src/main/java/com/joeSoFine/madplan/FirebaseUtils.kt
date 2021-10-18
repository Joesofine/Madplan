package com.joeSoFine.madplan

import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.getField
import kotlinx.coroutines.tasks.await

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

private suspend fun getListOfdays(): List<DocumentSnapshot> {
    val snapshot = FirebaseUtils().fireStoreDatabase.collection("days").get().await()
    return snapshot.documents
}

private suspend fun getDataFromFirestore() {
    try {
        val listOfdays = getListOfdays()
    } catch (e: Exception) {
        Log.d(TAG, e.message.toString()) //Don't ignore potential errors!
    }
}

fun readData(fireStoreCallback: FireStoreCallback) {
    FirebaseUtils().fireStoreDatabase.collection("days")
        .get()
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val list: ArrayList<String> = ArrayList()

                for (document in task.result!!){
                    val documentDay: String = document.data["dayName"].toString()
                    list.add(documentDay)
                }
                //
                fireStoreCallback.onCallback(list)

            } else {
                Log.w(TAG, "Error getting documents")
            }
        }
}


interface FireStoreCallback{
    fun onCallback(value: List<String>)
}


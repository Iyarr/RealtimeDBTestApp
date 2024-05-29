package com.realtimedbtest

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

public class RealTimeDB {
    private val database: FirebaseDatabase = Firebase.database
    private val myRef : DatabaseReference =
        database.getReference("https://realtimedbtest-9a79b-default-rtdb.firebaseio.com.us-central1.firebasedatabase.app")
    private var data: String? = ""

    fun putData() {
        myRef.setValue("Hello, World!")
    }

    fun getData() {
        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                data = dataSnapshot.getValue<String>()
                Log.d(TAG, "Value is: $data")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }
}
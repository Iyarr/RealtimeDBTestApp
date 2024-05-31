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
import com.realtimedbtest.RealTimeDB

public class RealTimeDB {
    private val database: FirebaseDatabase = Firebase.database
    // Don't pass Database path
    private val myRef : DatabaseReference =
        database.getReference("message")

    fun putData() {
        myRef.setValue("Hello, World!")
    }

    fun getData() {
        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val data = dataSnapshot.getValue<String>()
                Log.d(TAG, "Value is: $data")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }
}
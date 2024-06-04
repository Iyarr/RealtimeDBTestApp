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

    private fun getRef(table: String): DatabaseReference {
        return database.getReference(table)
    }

    // Screen is changed, this listener is cancelled
    private fun setEventListenerToRef(ref: DatabaseReference) {
        ref.addValueEventListener(object : ValueEventListener {
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
    fun getUserTable(userId: String): DatabaseReference {
        return getRef("User/$userId")
    }

    // Start of test function for Murase
    fun putData(value: String) {
        val myRef = getRef("message")
        myRef.setValue(value)
    }

    fun setLogModeToRef() {
        val myRef : DatabaseReference = getRef("message")
        // Set EventListener to this DatabaseReference
        setEventListenerToRef(myRef)
    }
    // Last
}
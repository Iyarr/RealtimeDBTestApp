package com.realtimedbtest

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

public class RealTimeDB {
    private val database: FirebaseDatabase = Firebase.database
    private val myRef : DatabaseReference =
        database.getReference("https://DATABASE_NAME.REGION.firebasedatabase.app")

    fun putData() {
        myRef.setValue("Hello, World!")
    }

    fun getData() {

    }
}
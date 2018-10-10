package br.com.guiacistore.interfaces

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

interface IFirebase  {

    fun doDatabaseInstance(id:Int) : Boolean


    val databaseInstance: FirebaseDatabase?
        get() = null

    val referenciaFirebase: DatabaseReference?
        get() = null

}
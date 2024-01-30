package com.example.alimentosnavidad.conexion

import android.content.Context
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class BDFireBase(private val context: Context): ConexionBD() {

    val conexion = Firebase.firestore

    override fun borrarArchivos() {
        TODO("Not yet implemented")
    }

}
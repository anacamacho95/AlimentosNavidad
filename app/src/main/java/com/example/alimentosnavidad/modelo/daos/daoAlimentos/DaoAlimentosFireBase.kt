package com.example.alimentosnavidad.modelo.daos.daoAlimentos

import android.util.Log
import com.example.alimentosnavidad.conexion.BDFireBase
import com.example.alimentosnavidad.conexion.ConexionBD
import com.example.alimentosnavidad.modelo.entidades.Alimento
import com.example.alimentosnavidad.modelo.interfaces.InterfaceCreateConexion
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos
import com.google.firebase.firestore.FirebaseFirestore

class DaoAlimentosFireBase:InterfaceDaoAlimentos, InterfaceCreateConexion {
    lateinit var conexion: FirebaseFirestore

    override fun addAlimento(al: Alimento) {
        conexion.collection("alimentos")
            .add(al)
            .addOnSuccessListener { documentReference ->
                Log.d("firebase", "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.d("firebase", "Error adding document", e)
            }
    }

    override fun getAlimentos(): MutableList<Alimento> {
        var  alimentos:MutableList<Alimento> = mutableListOf()

        // Realizar la consulta asíncrona
        conexion.collection("alimentos")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        val alimento = document.toObject(Alimento::class.java)
                        alimento.idAlimentoFB=document.id
                        alimentos.add(alimento)
                    }
                    //aqui es donde se muestran los resultados. Los del main no tienen datos aún. Esto es un metodo asincrono
                    alimentos.forEach {
                        Log.d("firebase",it.idAlimentoFB+"--"+it.nombre)
                    }
                }
                else {
                    Log.d("firebase", "Error al obtener documentos.", task.exception)
                }
            }
        return alimentos
    }

    override fun getAlimentos(tipo: String): MutableList<Alimento> {
        var alimentos:MutableList<Alimento> = mutableListOf()

        conexion.collection("alimentos")
            .whereEqualTo("tipo", tipo)
            .get()
            .addOnSuccessListener { querySnapshot ->

                for (document in querySnapshot) {
                    val alimento = document.toObject(Alimento::class.java)
                    alimentos.add(alimento)
                }
                alimentos.forEach {
                    Log.d("firebase",it.idAlimentoFB+"--"+it.nombre)
                }
            }
            .addOnFailureListener { exception ->
                //control de error
            }
        return alimentos
    }

    override fun getAlimento(nombre: String): Alimento? {
        val docRef = conexion.collection("alimentos").document(nombre)

        return try {
            docRef.get()
                .addOnSuccessListener { documentSnapshot ->
                    if (documentSnapshot.exists()) {
                        val alimento = documentSnapshot.toObject(Alimento::class.java)
                        alimento?.idAlimentoFB = documentSnapshot.id
                        // Aquí puedes hacer algo con el alimento, como imprimirlo en el log
                        Log.d("Firebase", "Alimento encontrado: ${alimento?.nombre}")
                    } else {
                        // El documento no existe
                        Log.d("Firebase", "Alimento no encontrado.")
                    }
                }
                .addOnFailureListener { e ->
                    // Manejar el error
                    Log.e("Firebase", "Error al obtener el alimento", e)
                }
            null
        } catch (e: Exception) {
            // Manejar errores sincrónicos
            Log.e("Firebase", "Error al obtener el alimento", e)
            null
        }
    }

    override fun getAlimento(id: Int): Alimento? {
        TODO("Not yet implemented")
    }


    override fun updateAlimento(alAntiguo: Alimento, alNuevo: Alimento) {
        conexion.collection("alimentos")
            .document(alAntiguo.idAlimentoFB!!)
            .set(alNuevo)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("firebase", "Documento actualizado.")
                } else {
                    Log.d("firebase", "Error al actualizar documento.", task.exception)
                }
            }
    }

    override fun deleteAlimento(al: Alimento) {
        conexion.collection("alimentos")
            .document(al.idAlimentoFB!!)
            .delete()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Aquí es donde deberías manejar el resultado de la eliminación.
                } else {
                    Log.d("firebase", "Error al eliminar documento.", task.exception)
                }
            }
    }

    override fun createConexion(con: ConexionBD) {
        conexion = (con as BDFireBase).conexion
    }
}
package com.example.alimentosnavidad.modelo.daos.daoIngredientes

import com.example.alimentosnavidad.conexion.BDFireBase
import com.example.alimentosnavidad.conexion.ConexionBD
import com.example.alimentosnavidad.modelo.entidades.Ingrediente
import com.example.alimentosnavidad.modelo.interfaces.InterfaceCreateConexion
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes
import com.google.firebase.firestore.FirebaseFirestore

class DaoIngredientesFirebase: InterfaceDaoIngredientes, InterfaceCreateConexion {

    lateinit var conexion: FirebaseFirestore
    override fun createConexion(con: ConexionBD) {
        this.conexion = (con as BDFireBase).conexion
    }
    override fun addIngrediente(ing: Ingrediente) {
        TODO("Not yet implemented")
    }

    override fun getIngredientesByAlimento(id: Int): MutableList<Ingrediente> {
        TODO("Not yet implemented")
    }

    override fun getNombreIngredientesByAlimento(id: Int): MutableList<String> {
        TODO("Not yet implemented")
    }

    override fun updateIngrediente(ing: Ingrediente) {
        TODO("Not yet implemented")
    }

    override fun deleteAlimento(ing: Ingrediente) {
        TODO("Not yet implemented")
    }


}
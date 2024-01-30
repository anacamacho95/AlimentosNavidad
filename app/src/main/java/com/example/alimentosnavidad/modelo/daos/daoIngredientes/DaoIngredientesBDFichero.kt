package com.example.alimentosnavidad.modelo.daos.daoIngredientes

import com.example.alimentosnavidad.conexion.BDFicheroAlimentos
import com.example.alimentosnavidad.conexion.ConexionBD
import com.example.alimentosnavidad.modelo.entidades.Ingrediente
import com.example.alimentosnavidad.modelo.factorias.FactoryConexiones
import com.example.alimentosnavidad.modelo.interfaces.InterfaceCreateConexion
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes

class DaoIngredientesBDFichero: InterfaceDaoIngredientes, InterfaceCreateConexion {
    lateinit var conexion: BDFicheroAlimentos
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

    override fun createConexion(con: ConexionBD) {
        conexion = con as BDFicheroAlimentos
    }
}
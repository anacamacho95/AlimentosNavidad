package com.example.alimentosnavidad.modelo.daos.daoIngredientes

import android.content.ContentValues
import com.example.alimentosnavidad.conexion.BDAlimentosSQLite
import com.example.alimentosnavidad.conexion.BDSqlite
import com.example.alimentosnavidad.conexion.ConexionBD
import com.example.alimentosnavidad.modelo.entidades.Ingrediente
import com.example.alimentosnavidad.modelo.interfaces.InterfaceCreateConexion
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes

class DaoIngredientesSqlite: InterfaceDaoIngredientes, InterfaceCreateConexion {

    lateinit var conexion: BDSqlite

    override fun addIngrediente(ing: Ingrediente) {
        val db = conexion.writableDatabase
        val values = ContentValues()
        values.put("alimentoHijoId", ing.alimentoHijoId)
        values.put("alimentoPadreId", ing.alimentoPadreId)
        values.put("cantidad", ing.cantidad)
        db.insert("ingrediente", null, values)
        conexion.close()
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
        conexion= (con as BDAlimentosSQLite).conexion
    }
}
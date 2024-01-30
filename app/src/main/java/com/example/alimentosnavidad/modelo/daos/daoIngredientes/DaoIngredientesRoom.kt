package com.example.alimentosnavidad.modelo.daos.daoIngredientes

import com.example.alimentosnavidad.conexion.BDAlimentosRoom
import com.example.alimentosnavidad.conexion.ConexionBD
import com.example.alimentosnavidad.modelo.entidades.Ingrediente
import com.example.alimentosnavidad.modelo.interfaces.InterfaceCreateConexion
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes

class DaoIngredientesRoom: InterfaceDaoIngredientes, InterfaceCreateConexion {

    lateinit var db: BDAlimentosRoom
    override fun createConexion(con: ConexionBD) {
        db = con as BDAlimentosRoom
    }

    override fun addIngrediente(ing: Ingrediente) {
        db.conexion.daoIngrediente().addIngrediente(ing)
    }

    override fun getIngredientesByAlimento(id: Int): MutableList<Ingrediente> {

        val ingredientes= db.conexion.daoIngrediente().getIngredientesByAlimento(id)
        if(ingredientes.size!=0) {
            ingredientes.forEach {
                it.alimentoHijo = db.conexion.daoAlimento().getAlimento(it.alimentoHijoId)!!
                it.alimentoPadre = db.conexion.daoAlimento().getAlimento(it.alimentoPadreId)!!
            }
        }
        return ingredientes
    }

    override fun getNombreIngredientesByAlimento(id: Int): MutableList<String> {
        TODO("Not yet implemented")
    }

    override fun updateIngrediente(ing: Ingrediente) {
        db.conexion.daoIngrediente().updateIngrediente(ing)
    }

    override fun deleteAlimento(ing: Ingrediente) {
        db.conexion.daoIngrediente().deleteAlimento(ing)
    }


}
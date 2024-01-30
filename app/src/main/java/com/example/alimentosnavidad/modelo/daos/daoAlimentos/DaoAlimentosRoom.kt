package com.example.alimentosnavidad.modelo.daos.daoAlimentos

import com.example.alimentosnavidad.conexion.BDAlimentosRoom
import com.example.alimentosnavidad.conexion.ConexionBD
import com.example.alimentosnavidad.modelo.entidades.Alimento
import com.example.alimentosnavidad.modelo.interfaces.InterfaceCreateConexion
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos

class DaoAlimentosRoom:InterfaceDaoAlimentos,InterfaceCreateConexion {
    lateinit var db: BDAlimentosRoom
    override fun createConexion(con: ConexionBD) {
        db = con as BDAlimentosRoom
    }

    override fun addAlimento(al: Alimento) {
        db.conexion.daoAlimento().addAlimento(al)
    }

    override fun getAlimentos(): MutableList<Alimento> {
        return  db.conexion.daoAlimento().getAlimentos()
    }

    override fun getAlimentos(tipo: String): MutableList<Alimento> {
        return db.conexion.daoAlimento().getAlimentos(tipo)
    }

    override fun getAlimento(nombre: String): Alimento? {
        return db.conexion.daoAlimento().getAlimento(nombre)
    }

    override fun getAlimento(id: Int): Alimento? {
        return db.conexion.daoAlimento().getAlimento(id)
    }

    override fun updateAlimento(alAntiguo: Alimento,alNuevo: Alimento) {
        return db.conexion.daoAlimento().updateAlimento(alAntiguo,alNuevo)
    }

    override fun deleteAlimento(al: Alimento) {
        return db.conexion.daoAlimento().deleteAlimento(al)
    }


}
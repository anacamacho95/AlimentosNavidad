package com.example.alimentosnavidad.modelo.daos.daoAlimentos

import com.example.alimentosnavidad.conexion.BDFicheroAlimentos
import com.example.alimentosnavidad.conexion.ConexionBD
import com.example.alimentosnavidad.modelo.entidades.Alimento
import com.example.alimentosnavidad.modelo.interfaces.InterfaceCreateConexion
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos

class DaoAlimentosBDFichero : InterfaceDaoAlimentos, InterfaceCreateConexion {

    lateinit var conexion: BDFicheroAlimentos
    override fun createConexion(con: ConexionBD) {
        conexion = con as BDFicheroAlimentos
    }
    override fun addAlimento(al: Alimento) {
        val lista=conexion.leer()
        lista.add(al)
        conexion.escribir(lista)    }

    override fun getAlimentos(): MutableList<Alimento> {
        return conexion.leer()
    }

    override fun getAlimentos(tipo: String): MutableList<Alimento> {
        val lista=conexion.leer()
        return lista.filter{it.tipo==tipo} as MutableList<Alimento>
    }

    override fun getAlimento(nombre: String): Alimento? {
        val lista = conexion.leer()
        return lista.find { it.nombre == nombre }
    }

    override fun getAlimento(id: Int): Alimento? {
        val lista = conexion.leer()
        return lista.find { it.idAlimento == id }
    }

    override fun updateAlimento(alAntiguo: Alimento,alNuevo: Alimento) {
        val lista=conexion.leer()
        val indice=lista.indexOf(alAntiguo)
        lista.set(indice,alNuevo)
        conexion.escribir(lista)    }

    override fun deleteAlimento(al: Alimento) {
        val lista=conexion.leer()
        lista.remove(al)
        conexion.escribir(lista)    }


}
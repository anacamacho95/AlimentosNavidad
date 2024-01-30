package com.example.alimentosnavidad.modelo.factorias

import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes

abstract class AbstractFactoryDaos {
    abstract fun createDaoAlimentos(): InterfaceDaoAlimentos
    abstract fun createDaoIngredientes(): InterfaceDaoIngredientes
    //Esto equivale a un método estático en Java
    companion object {
        //Esta función devuelve una factoría concreta, según
        // el parámetro "tipo"
        fun createFactory(tipo:String): AbstractFactoryDaos? {
            return when (tipo){
                "fichero"-> FactoryDaoBDFichero()
                "sqlite" -> FactoryDaoSqlite()
                "room" -> FactoryDaoRoom()
                "firebase" -> FactoryDaoFirebase()
                else->null
            }
        }
    }
}
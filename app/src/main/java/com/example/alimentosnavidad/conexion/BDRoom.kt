package com.example.alimentosnavidad.conexion

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.alimentosnavidad.modelo.entidades.Alimento
import com.example.alimentosnavidad.modelo.entidades.Ingrediente
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes

class BDAlimentosRoom(private val context: Context): ConexionBD(){

    val conexion= BDRoom.getBaseDatos(context)

    override fun borrarArchivos() {
        val sql1="DROP TABLE Alimento"
        val sql2="DROP TABLE Ingrediente"
    }

}

@Database(entities = [Alimento::class, Ingrediente::class], version = 1)
abstract class BDRoom: RoomDatabase() {

    abstract fun daoAlimento(): InterfaceDaoAlimentos
    abstract fun daoIngrediente(): InterfaceDaoIngredientes

    companion object {
        var INSTANCE: BDRoom?=null
        fun getBaseDatos(context: Context): BDRoom {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    BDRoom::class.java,
                    "alimentosDB"
                ).allowMainThreadQueries().build()

            }
            return INSTANCE as BDRoom
        }
    }

}
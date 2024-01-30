package com.example.alimentosnavidad.modelo.interfaces

import androidx.room.*
import com.example.alimentosnavidad.modelo.entidades.Alimento

@Dao
interface InterfaceDaoAlimentos {
    @Insert
    fun addAlimento(al: Alimento)
    @Query("SELECT * FROM alimento")
    fun getAlimentos():MutableList<Alimento>
    @Query("SELECT * FROM alimento WHERE tipo LIKE :tipo")
    fun getAlimentos(tipo:String):MutableList<Alimento>
    @Query("SELECT * FROM alimento WHERE nombre LIKE :nombre")
    fun getAlimento(nombre: String):Alimento?
    @Query("SELECT * FROM alimento WHERE idAlimento LIKE :id")
    fun getAlimento(id:Int):Alimento?
    @Update
    fun updateAlimento(alAntiguo: Alimento, alNuevo: Alimento)
    @Delete
    fun deleteAlimento(al:Alimento)

}
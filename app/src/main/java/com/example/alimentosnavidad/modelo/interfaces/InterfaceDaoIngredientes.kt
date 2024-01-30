package com.example.alimentosnavidad.modelo.interfaces

import androidx.room.*
import com.example.alimentosnavidad.modelo.entidades.Ingrediente

@Dao
interface InterfaceDaoIngredientes {
    @Insert
    fun addIngrediente(ing: Ingrediente)
    @Query("SELECT * FROM ingrediente WHERE alimentoPadreId LIKE :id")
    fun getIngredientesByAlimento(id:Int):MutableList<Ingrediente>
    @Query("""SELECT a.nombre FROM Alimento a 
        INNER JOIN Ingrediente i ON a.idAlimento = i.alimentoHijoId 
        WHERE i.alimentoPadreId = :id""")
    fun getNombreIngredientesByAlimento(id:Int):MutableList<String>
    @Update
    fun updateIngrediente(ing:Ingrediente)
    @Delete
    fun deleteAlimento(ing:Ingrediente)

}
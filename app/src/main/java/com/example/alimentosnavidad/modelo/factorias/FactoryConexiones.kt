package com.example.alimentosnavidad.modelo.factorias

import android.content.Context
import com.example.alimentosnavidad.conexion.*

class FactoryConexiones (val context: Context) {
  lateinit var conexion: ConexionBD
    fun createConexion(tipoBD:String):ConexionBD{
         when (tipoBD){
            "fichero"->{
                conexion=  BDFicheroAlimentos(context)
             }
            "sqlite" ->{
                conexion = BDAlimentosSQLite(context)
            }
            "room" -> {
                conexion= BDAlimentosRoom(context)
                 }
            "firebase" ->{
                conexion= BDFireBase(context)
            }
            "apirest" ->{ }
            }
        conexion.tipoBD=tipoBD
        return conexion
    }
}
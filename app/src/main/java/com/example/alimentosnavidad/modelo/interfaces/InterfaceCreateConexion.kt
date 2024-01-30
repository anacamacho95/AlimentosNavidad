package com.example.alimentosnavidad.modelo.interfaces


import com.example.alimentosnavidad.conexion.ConexionBD

interface InterfaceCreateConexion {
    fun createConexion(con: ConexionBD)
}
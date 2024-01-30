package com.example.alimentosnavidad.modelo.daos.daoAlimentos

import android.content.ContentValues
import com.example.alimentosnavidad.conexion.BDAlimentosSQLite
import com.example.alimentosnavidad.conexion.BDSqlite
import com.example.alimentosnavidad.conexion.ConexionBD
import com.example.alimentosnavidad.modelo.entidades.Alimento
import com.example.alimentosnavidad.modelo.interfaces.InterfaceCreateConexion
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos

class DaoAlimentosSqlite: InterfaceDaoAlimentos, InterfaceCreateConexion {
    lateinit var conexion: BDSqlite

    override fun createConexion(con: ConexionBD) {
        conexion = (con as BDAlimentosSQLite).conexion
    }

    override fun addAlimento(al: Alimento) {
        val db = conexion.writableDatabase
        val values = ContentValues()
        values.put("nombre", al.nombre)
        values.put("tipo", al.tipo)
        values.put("grHC", al.grHC)
        values.put("grLip", al.grLip)
        values.put("grPro", al.grPro)
        values.put("cantidadTotal", al.cantidadTotal)
        values.put("Kcal", al.Kcal)
        db.insert("alimento", null, values)
        conexion.close()    }

    override fun getAlimentos(): MutableList<Alimento> {
        val lista = mutableListOf<Alimento>()
        val query = "SELECT * FROM Alimento"
        val db=conexion.readableDatabase
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val alimento = Alimento(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getDouble(3),
                    cursor.getDouble(4),
                    cursor.getDouble(5)
                )
                alimento.idAlimento=cursor.getInt(0)
                alimento.cantidadTotal = cursor.getDouble(6)
                alimento.Kcal = cursor.getDouble(7)

                lista.add(alimento)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return lista
    }

    override fun getAlimentos(tipo: String): MutableList<Alimento> {
        val query = "SELECT * FROM Alimento WHERE tipo = ?"
        val selectionArgs = arrayOf(tipo)
        val lista = mutableListOf<Alimento>()

        val db=conexion.readableDatabase
        val cursor = db.rawQuery(query, selectionArgs)

        if (cursor.moveToFirst()) {
            do {
                val alimento = Alimento(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getDouble(3),
                    cursor.getDouble(4),
                    cursor.getDouble(5)
                )
                alimento.idAlimento=cursor.getInt(0)
                alimento.cantidadTotal = cursor.getDouble(6)
                alimento.Kcal = cursor.getDouble(7)
                lista.add(alimento)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return lista
    }

    override fun getAlimento(nombre: String): Alimento? {

        val query = "SELECT * FROM Alimento WHERE nombre = ?"
        val selectionArgs = arrayOf(nombre)
        val db=conexion.readableDatabase
        val cursor = db.rawQuery(query, selectionArgs)

        if (cursor.moveToFirst()) {
            val alimento = Alimento(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getDouble(3),
                cursor.getDouble(4),
                cursor.getDouble(5)
            )
            alimento.idAlimento=cursor.getInt(0)
            alimento.cantidadTotal = cursor.getDouble(6)
            alimento.Kcal = cursor.getDouble(7)
            cursor.close()
            return alimento
        } else {
            cursor.close()
            return null
        }
    }

    override fun getAlimento(id: Int): Alimento? {
        TODO("Not yet implemented")
    }


    override fun updateAlimento(alAntiguo: Alimento, alNuevo: Alimento) {
        val db = conexion.writableDatabase
        val query = "UPDATE alimento SET nombre=?, tipo=?, grHC=?, grLip=?, grPro=?, cantidadTotal=?, Kcal=? WHERE idAlimento=?"
        val args = arrayOf(
            alNuevo.nombre,
            alNuevo.tipo,
            alNuevo.grHC.toString(),
            alNuevo.grLip.toString(),
            alNuevo.grPro.toString(),
            alNuevo.cantidadTotal.toString(),
            alNuevo.Kcal.toString(),
            alAntiguo.idAlimento.toString()
        )
        db.execSQL(query, args)
    }

    override fun deleteAlimento(al: Alimento) {
        val db = conexion.writableDatabase
        val query = "DELETE FROM alimento WHERE idAlimento=?"
        val args = arrayOf(al.idAlimento.toString())
        db.execSQL(query, args)
    }



}
package com.example.alimentosnavidad.conexion

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDAlimentosSQLite(private val context: Context): ConexionBD(){
    val conexion= BDSqlite(context)
    override fun borrarArchivos() {
        val sql1="DROP TABLE Alimento"
        val sql2="DROP TABLE Ingrediente"
        val db=conexion.getWritableDatabase();
        db.execSQL(sql1);
        db.execSQL(sql2);
        conexion.close();
    }

}

class BDSqlite(context: Context): SQLiteOpenHelper(context,
    DATABASE_NAME, null, DATABASE_VERSION ) {

    val TABLA_ALIMENTO = "CREATE TABLE Alimento (" +
            "idAlimento INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre TEXT," +
            "tipo TEXT," +
            "grHC REAL," +
            "grLip REAL," +
            "grPro REAL," +
            "cantidadTotal REAL," +
            "Kcal REAL);"

    val TABLA_INGREDIENTE = "CREATE TABLE Ingredientes (" +
            "idAlimento INTEGER PRIMARY KEY AUTOINCREMENT," +
            "idIngrediente INTEGER NOT NULL," +
            "cantidad REAL," +
            "FOREIGN KEY(idIngrediente) REFERENCES Alimento(idAlimento));"

    val SQL_DELETE_ENTRIES=""

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(TABLA_ALIMENTO)
        db.execSQL(TABLA_INGREDIENTE)

    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "alimentos.db"
    }
}
package com.example.alimentosnavidad.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import java.io.Serializable


@Entity(tableName = "ingrediente",
    primaryKeys = ["alimentoPadreId", "alimentoHijoId"],
    foreignKeys = [
        ForeignKey(
            entity = Alimento::class,
            parentColumns = ["idAlimento"],
            childColumns = ["alimentoPadreId"]
        ),
        ForeignKey(
            entity = Alimento::class,
            parentColumns = ["idAlimento"],
            childColumns = ["alimentoHijoId"]
        )
    ]
)
data class Ingrediente (
    @ColumnInfo(name = "alimentoPadreId") var alimentoPadreId: Int,
    @ColumnInfo(name = "alimentoHijoId") var alimentoHijoId: Int,
    @ColumnInfo(name = "cantidad") var cantidad:Double=0.0 ): Serializable {
    @Ignore
    lateinit var alimentoPadre:Alimento
    @Ignore
    lateinit var alimentoHijo: Alimento


    constructor(
        alimentoPadre: Alimento,
        alimentoHijo: Alimento,
        cantidad: Double=0.0) : this(
        alimentoPadre.idAlimento,
        alimentoHijo.idAlimento,
        cantidad
    ){
        this.alimentoPadre = alimentoPadre
        this.alimentoHijo = alimentoHijo
    }
}
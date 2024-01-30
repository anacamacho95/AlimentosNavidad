package com.example.alimentosnavidad.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="alimento")
data class Alimento (
    @ColumnInfo(name = "nombre") var nombre: String,
    @ColumnInfo(name = "tipo") var tipo:String="simple",
    @ColumnInfo(name = "grHC") var grHC: Double=0.0,
    @ColumnInfo(name = "grLip") var grLip:Double=0.0,
    @ColumnInfo(name = "grPro") var grPro:Double=0.0): Serializable {

    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name = "idAlimento") var idAlimento=0

    @ColumnInfo(name = "cantidadTotal") var cantidadTotal=0.0
    @ColumnInfo(name = "Kcal") var Kcal:Double=0.0

    @Ignore
    var idAlimentoFB:String=""
    @Ignore
    var ingredientes :MutableList<Ingrediente> = mutableListOf()
    @Ignore
    var contenedores :MutableList<Alimento> = mutableListOf()

    init{
        if (tipo=="simple"||tipo=="procesado"){
            cantidadTotal=100.0
        }
        calculaKcal()
    }

    constructor() : this("", "simple", 0.0, 0.0, 0.0)

    fun addIngrediente(ing: Ingrediente){
        ingredientes.add(ing)
        ing.alimentoHijo.contenedores.add(this)
        this.calculaCantidades(ing)
        this.calculaKcal()
    }

    fun RecalculaRecursivo(){
        contenedores.forEach {
            it.recalcula()
            it.RecalculaRecursivo()
        }
    }

    fun recalcula(){
        this.cantidadTotal=0.0
        this.grHC=0.0
        this.grLip=0.0
        this.grPro=0.0
        for(ing in ingredientes){
            if (ing!=null) {
                this.calculaCantidades(ing)
                this.calculaKcal()
            }
        }
    }

    fun calculaKcal() {
        this.Kcal=(4*grHC+4*grPro+9*grLip)
    }

    private fun calculaCantidades(ing: Ingrediente){
        this.cantidadTotal+=ing.cantidad
        this.grHC+=ing.alimentoHijo.grHC*ing.cantidad/ing.alimentoHijo.cantidadTotal
        this.grLip+=ing.alimentoHijo.grLip*ing.cantidad/ing.alimentoHijo.cantidadTotal
        this.grPro+=ing.alimentoHijo.grPro*ing.cantidad/ing.alimentoHijo.cantidadTotal
    }
}
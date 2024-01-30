package com.example.alimentosnavidad.ModelViews

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.alimentosnavidad.conexion.ConexionBD
import com.example.alimentosnavidad.modelo.entidades.Alimento
import com.example.alimentosnavidad.modelo.entidades.Ingrediente
import com.example.alimentosnavidad.modelo.factorias.AbstractFactoryDaos
import com.example.alimentosnavidad.modelo.factorias.FactoryConexiones
import com.example.alimentosnavidad.modelo.interfaces.InterfaceCreateConexion
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes


class ServiceModelView(application: Application): AndroidViewModel(application),
    InterfaceDaoAlimentos {
    private val fc= FactoryConexiones(application)
    lateinit private var conexion: ConexionBD
    lateinit private var fdao: AbstractFactoryDaos

    private lateinit var daoAlimentos:InterfaceDaoAlimentos
    private lateinit var daoIngredientes: InterfaceDaoIngredientes

    private lateinit var alimentos:MutableList<Alimento>
    private lateinit var alimento:Alimento
    private lateinit var ingrediente: Ingrediente
    private lateinit var ingredientes:MutableList<Ingrediente>

    fun createService(tipoBD:String){
        conexion=fc.createConexion(tipoBD)
        fdao = AbstractFactoryDaos.createFactory(tipoBD)!!
        if (fdao != null) {
            daoAlimentos = fdao.createDaoAlimentos()
            (daoAlimentos as InterfaceCreateConexion).createConexion(conexion)
            daoIngredientes = fdao.createDaoIngredientes()
            (daoIngredientes as InterfaceCreateConexion).createConexion(conexion)
        }

    }

    override fun addAlimento(al: Alimento) {
        daoAlimentos.addAlimento(al)
    }
    override fun getAlimentos(): MutableList<Alimento> {
        this.alimentos= daoAlimentos.getAlimentos()
        return alimentos
    }
    override fun getAlimentos(tipo: String): MutableList<Alimento> {
        alimentos= daoAlimentos.getAlimentos(tipo)
        return alimentos
    }

    override fun getAlimento(nombre: String): Alimento{
        alimento= daoAlimentos.getAlimento(nombre)!!

        return alimento
    }
    override fun getAlimento(id: Int): Alimento? {
        return daoAlimentos.getAlimento(id)
    }

    override fun updateAlimento(alAntiguo: Alimento, alNuevo: Alimento) {
        return daoAlimentos.updateAlimento(alAntiguo, alNuevo)
    }

    fun addIngredienteRoom(alimentoHijo:Alimento, alimentoPadre:Alimento, cantidad:Double){

    }

    override fun deleteAlimento(al: Alimento) {
        TODO("Not yet implemented")
    }

    fun recalculaBack(al:Alimento){

    }

    }




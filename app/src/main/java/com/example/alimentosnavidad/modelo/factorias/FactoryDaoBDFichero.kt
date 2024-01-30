package com.example.alimentosnavidad.modelo.factorias

import com.example.alimentosnavidad.conexion.BDFicheroAlimentos
import com.example.alimentosnavidad.modelo.daos.daoAlimentos.DaoAlimentosBDFichero
import com.example.alimentosnavidad.modelo.daos.daoIngredientes.DaoIngredientesBDFichero
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes

class FactoryDaoBDFichero: AbstractFactoryDaos() {

    lateinit var conexion: BDFicheroAlimentos

    override fun createDaoAlimentos(): InterfaceDaoAlimentos {
        return DaoAlimentosBDFichero()
    }

    override fun createDaoIngredientes(): InterfaceDaoIngredientes {
        return DaoIngredientesBDFichero()
    }
}
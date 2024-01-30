package com.example.alimentosnavidad.modelo.factorias

import com.example.alimentosnavidad.modelo.daos.daoAlimentos.DaoAlimentosFireBase
import com.example.alimentosnavidad.modelo.daos.daoIngredientes.DaoIngredientesFirebase
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes

class FactoryDaoFirebase: AbstractFactoryDaos() {
    override fun createDaoAlimentos(): InterfaceDaoAlimentos {
        return DaoAlimentosFireBase()
    }

    override fun createDaoIngredientes(): InterfaceDaoIngredientes {
        return DaoIngredientesFirebase()
    }
}
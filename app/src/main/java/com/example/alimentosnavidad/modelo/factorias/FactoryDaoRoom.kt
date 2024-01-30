package com.example.alimentosnavidad.modelo.factorias

import com.example.alimentosnavidad.modelo.daos.daoAlimentos.DaoAlimentosRoom
import com.example.alimentosnavidad.modelo.daos.daoIngredientes.DaoIngredientesRoom
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes

class FactoryDaoRoom: AbstractFactoryDaos() {
    override fun createDaoAlimentos(): InterfaceDaoAlimentos {
        return DaoAlimentosRoom()
    }

    override fun createDaoIngredientes(): InterfaceDaoIngredientes {
        return DaoIngredientesRoom()
    }
}
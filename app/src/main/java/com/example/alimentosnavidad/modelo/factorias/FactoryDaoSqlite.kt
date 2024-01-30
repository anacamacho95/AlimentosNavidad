package com.example.alimentosnavidad.modelo.factorias

import com.example.alimentosnavidad.modelo.daos.daoAlimentos.DaoAlimentosRoom
import com.example.alimentosnavidad.modelo.daos.daoAlimentos.DaoAlimentosSqlite
import com.example.alimentosnavidad.modelo.daos.daoIngredientes.DaoIngredientesSqlite
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes

class FactoryDaoSqlite: AbstractFactoryDaos() {
    override fun createDaoAlimentos(): InterfaceDaoAlimentos {
        return DaoAlimentosSqlite()
    }

    override fun createDaoIngredientes(): InterfaceDaoIngredientes {
        return DaoIngredientesSqlite()
    }

}
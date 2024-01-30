package com.example.alimentosnavidad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.alimentosnavidad.ModelViews.ServiceModelView
import com.example.alimentosnavidad.conexion.*
import com.example.alimentosnavidad.modelo.entidades.Alimento
import com.example.alimentosnavidad.modelo.entidades.Ingrediente
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoAlimentos
import com.example.alimentosnavidad.modelo.interfaces.InterfaceDaoIngredientes

class MainActivity : AppCompatActivity() {
    //lateinit var alimento: Alimento

    lateinit var conexion: ConexionBD
    private  val svm: ServiceModelView by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pruebaModelo()
    }

    private fun pruebaModelo() {
        svm.createService("room")

        var huevo=Alimento("huevo","simple",10.0)
        svm.addAlimento(huevo)
        var patatas=Alimento("patatas","simple",10.0)
        svm.addAlimento(patatas)
        var tomate=Alimento("tomate","simple")
        svm.addAlimento(tomate)
        var pan=Alimento("pan","simple")
        svm.addAlimento(pan)
        var tortilla=Alimento("tortilla","receta")
        tortilla.addIngrediente(Ingrediente(tortilla, huevo,200.0))
        tortilla.addIngrediente(Ingrediente(tortilla, patatas,200.0))
        svm.addAlimento(tortilla)
        var ensalada=Alimento("ensalada", "receta")
        svm.addAlimento(ensalada)
        var menu=Alimento("menu","menu")
        menu.addIngrediente(Ingrediente(menu, tortilla,200.0))
        menu.addIngrediente(Ingrediente(menu, pan,10.0))
        svm.addAlimento(menu)
        var dieta=Alimento("dieta","dieta")
        dieta.addIngrediente(Ingrediente(dieta, ensalada))
        dieta.addIngrediente(Ingrediente(dieta, tomate,100.0))
        //dieta.recalcula()
        svm.addAlimento(dieta)


        //ver lista
        val lista=svm.getAlimentos()
        lista.forEach{
            Log.d("lista", it.nombre + " "+it.Kcal)
        }

        //buscar por nombre
        val obtener=svm.getAlimento("patatas")
        if (obtener != null) {
            Log.d("busca", "Alimento encontrado: ${obtener.nombre} ${obtener.Kcal}")
        } else {
            Log.d("busca", "No se encontró el alimento con el nombre $obtener")
        }

        //buscar por tipo
        val tipo=svm.getAlimentos("receta")
        tipo.forEach{
            Log.d("tipo", it.nombre + " "+it.Kcal)
            //svm.deleteAlimento(it)
        }


       // conexion.borrarArchivos()
    }
}
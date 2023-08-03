package ean.estructuradedatos.arboles

import ean.collections.IBinTree
import ean.collections.IList
import ean.collections.TList

data class Carro(private val placa: String,private val añoFabricacion: Int, private val cilindraje: Double, private val nombreDueño:String,private val marca:String) {
    fun placa():String{
        return placa
    }
    fun añoFabricacion():Int{
        return añoFabricacion
    }
    fun cilindraje():Double{
        return cilindraje
    }
    fun nombreDueño():String{
        return nombreDueño
    }
    fun marca():String{
        return marca
    }
}

fun nombresMarca(arbol: IBinTree<Carro>): IList<String> {
    return if (arbol.isEmpty){
        TList()
    }
    else{
        val nombresIz = nombresMarca(arbol.left)
        val nombresDer = nombresMarca(arbol.right)
        var resp = nombresIz + nombresDer
        if ((arbol.root.marca()  == "mercedes" || arbol.root.marca()  == "bmw") && (arbol.root.añoFabricacion() > 50) ){
            resp.add(arbol.root.nombreDueño())
        }
        resp

    }
}
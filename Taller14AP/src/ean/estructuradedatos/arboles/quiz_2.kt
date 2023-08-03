package ean.estructuradedatos.arboles

import ean.collections.IBinTree

data class Edificio(private val nombre: String,private val barrio: String, private val numPisos: Int) {
    fun getNombre():String{
        return nombre
    }
    fun getBarrio():String{
        return barrio
    }
    fun getNumPisos():Int{
        return numPisos
    }

}
fun edificioMasAltoEntreDos (a:Edificio?,b:Edificio?): Edificio? {


    if (a == null && b == null){
        return null
    }
    else if (a != null && b == null){
        return a
    }
    else if (b != null && a == null){
        return b
    }
    else{

        if(a!!.getNumPisos() < b!!.getNumPisos()){
            return b
        }
        return a

    }

}

fun edificioMasGrandeArbol(arbol: IBinTree<Edificio>): Edificio? {
    if (arbol.isEmpty){
        return null
    }


    else{
        var mayorIzquierdo = edificioMasGrandeArbol(arbol.left)
        var mayorDerecho = edificioMasGrandeArbol(arbol.right)
        var mayorIzDer = edificioMasAltoEntreDos(mayorIzquierdo,mayorDerecho)
        var edificioMasGrande:Edificio

        if (mayorIzDer != null) {
            edificioMasGrande = edificioMasAltoEntreDos(mayorIzDer, arbol.root)!!
        }
        else{
           edificioMasGrande=(arbol.root)
        }

        return edificioMasGrande
    }

}
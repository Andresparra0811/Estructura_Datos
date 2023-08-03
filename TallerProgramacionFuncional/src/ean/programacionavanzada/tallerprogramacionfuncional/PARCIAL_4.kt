package ean.programacionavanzada.tallerprogramacionfuncional

import ean.collections.IList
import ean.collections.TList

fun multiplos3(lista: IList<Int>):Boolean{
    return lista.all { it % 3 ==0 }
}
fun main(){
    val lista:IList<Int> = TList(3,6,9,12,15,18)
    println(multiplos3(lista))
}
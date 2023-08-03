
import ean.collections.IList
import ean.collections.TList

fun sumarParesLista(lista: IList<Int>): Int {

    if (lista.isEmpty){
        return 0
    }


    else{
        val primero = lista.head()
        println ("$primero")
        val resto = lista.tail()
        val sumaParesResto= sumarParesLista(resto)
        if (primero % 2 == 0){
            return sumaParesResto + primero
        }
        else{
            return sumaParesResto
        }
    }



}
fun main (){
    val lista: IList<Int> = TList(4,5,6,7,8,9,10,11,12)
    sumarParesLista(lista)

}
package ean.tallerordenamiento

import ean.collections.IList
import ean.collections.TList

fun <T:Comparable<T>> coboSort (a: IList<T>):IList<T>{
    var copiaA:IList<T> = a.copy()
    var resultado:IList<T> = TList()
    var i= 0
    var mayorCopia= copiaA[0]

    while(i<copiaA.size && !copiaA.isEmpty ){
        if (copiaA[i] > mayorCopia){
            mayorCopia=copiaA[i]
            resultado.add(copiaA[i])
            copiaA.remove(i)

        }
        else{
            i++
        }
    }

    return resultado
}


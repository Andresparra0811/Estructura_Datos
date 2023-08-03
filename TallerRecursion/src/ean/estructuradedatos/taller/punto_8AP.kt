package ean.estructuradedatos.taller

import ean.collections.IList
import ean.collections.TList

fun binarioToBCD (listaBinario: IList<Int>): IList<Char>{
    require(listaBinario.size % 3 == 0)
    if (listaBinario.isEmpty){
        return TList()
    }
    else{
        val primeros:IList<Int> = TList()
        val primero= listaBinario.get(0)
        val segundo= listaBinario.get(1)
        val tercero= listaBinario.get(2)

        primeros.add(primero)
        primeros.add(segundo)
        primeros.add(tercero)

        listaBinario.remove(0)
        listaBinario.remove(1)
        listaBinario.remove(2)

        val convertirRestoBinario = binarioToBCD(listaBinario)
        var convertir_primero:Char = '0'
        if (primeros.get(0)== 0 && primeros.get(1)== 0 && primeros.get(2)== 0){
            convertir_primero= 'A'
        }
        else if (primeros.get(0)== 0 && primeros.get(1)== 0 && primeros.get(2)== 1){
            convertir_primero= '1'
        }
        else if (primeros.get(0)== 0 && primeros.get(1)== 1 && primeros.get(2)== 0){
            convertir_primero= 'B'
        }
        else if (primeros.get(0)== 0 && primeros.get(1)== 1 && primeros.get(2)== 1){
            convertir_primero= '3'
        }
        else if (primeros.get(0)== 1 && primeros.get(1)== 0 && primeros.get(2)== 0){
            convertir_primero= 'C'
        }
        else if (primeros.get(0)== 1 && primeros.get(1)== 0 && primeros.get(2)== 1){
            convertir_primero= '5'
        }
        else if (primeros.get(0)== 1 && primeros.get(1)== 1 && primeros.get(2)== 0){
            convertir_primero= 'D'
        }
        else if (primeros.get(0)== 1 && primeros.get(1)== 1 && primeros.get(2)== 1){
            convertir_primero= '7'
        }
        convertirRestoBinario.addToHead(convertir_primero)
        return convertirRestoBinario
    }
}
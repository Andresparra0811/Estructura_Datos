package ean.programacionavanzada.tallerprogramacionfuncional

import ean.collections.IList
import ean.collections.TList

fun ultimoMayorDigitos (lista: IList<Int>):Int{

        var digitos=0
        var numMasDigitos= 0
        for (num in lista){
            var numeroString= num.toString()
            var digitosNumero= numeroString.length
            if (numeroString[0] == '-'){
                digitosNumero= numeroString.length - 1
            }

            if (digitosNumero > digitos){
                digitos= digitosNumero
                numMasDigitos= num
            }
            else if (digitosNumero == digitos)
                numMasDigitos= lista.findLast { digitosNumero == digitos }!!

        }
        return numMasDigitos
    }

fun main(){
    val lista:IList<Int> = TList(1,2,3,55,-1456,1457)
    println(ultimoMayorDigitos(lista))
}
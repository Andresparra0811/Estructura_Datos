package quiz_pilas

import ean.collections.IStack
import ean.collections.TLinkedStack

fun tamaño__pilas (pila1: IStack<Double>,pila2: IStack<Double>):Boolean{

    var copia1_contar= pila1.copy()
    var copia2_contar= pila2.copy()
    var cont1=0
    var cont2=0
    val verificar= false

    while(!copia1_contar.isEmpty){
        cont1++
        copia1_contar.pop()
    }

    while(!copia2_contar.isEmpty){
        cont2++
        copia2_contar.pop()
    }

    if (cont1 == cont2){
        verificar= true
        }
    return verificar
    }

fun <T> invertirPila(pila: IStack<T>): IStack<T> {
    val auxiliar: IStack<T> = TLinkedStack()
    while (!pila.isEmpty){
        auxiliar.push(pila.peek())
        pila.pop()
    }
    return auxiliar

}

fun EQU (pila1: IStack<Double>,pila2: IStack<Double>){
    var copia1= invertirPila(pila1.copy())
    var copia2= invertirPila(pila2.copy())
    val equ: IStack<Double> = TLinkedStack()
    var añadir_equ:Double
    var verificar= tamaño__pilas(pila1,pila2)

    if (verificar== true){
        while (!copia1.isEmpty){
            if (copia1.peek()== copia2.peek()){
                añadir_equ= copia1.peek() + copia2.peek()
                equ.push(añadir_equ)
            }

            else {
                añadir_equ= (copia1.peek() + copia2.peek())/2
                equ.push(añadir_equ)
                }
        }
        return equ
    }
    return null
}

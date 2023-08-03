package ean.estructuradedatos.tallerpilas

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 * <p>
 * Proyecto Taller con las Pilas
 * Autor: Universidad EAN - Marzo 18, 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.*

/**
 * Objeto que permite convertir una expresión infija normal a una expresión en notación
 * postfija. Utiliza pilas para realizar la conversión.
 */
object Evaluador {

    //-------------------------------------
    // Métodos
    //-------------------------------------

    /**
     * Verifica que la expresión tiene los símbolos de agrupación bien balanceados
     * @return true si la expresión está balanceados
     */
    fun estánSímbolosAgrupaciónBalanceados(expresion: IList<String>): Boolean {
        val pilaSimbolos: IStack<String> = TLinkedStack()

        for (x in expresion) {
            if ((x=="(") || (x=="{") || (x=="[") ){
                pilaSimbolos.push(x)
            }

            else if ((x==")") || (x=="}") || (x=="]")){
                if (pilaSimbolos.isEmpty){
                   return false
                }

                var delimitador= pilaSimbolos.peek()
                pilaSimbolos.pop()

                if ((delimitador == "(" && x != ")") || (delimitador == "{" && x != "}") || (delimitador == "[" && x != "]")){
                   return false
                 }

            }
        }

        return pilaSimbolos.isEmpty != false


}

    /**
     * Transforma la expresión, cambiando los simbolos de agrupación [] y {} por ()
     */
    fun reemplazarDelimitadoresPorParéntesis(expresion: IList<String>): Unit {
        for (x in 0 until expresion.size) {
            if (expresion[x] == "{" || expresion[x] == "[" ) {
                expresion[x] = "("
            }
            else {
                if (expresion[x] == "}" || expresion[x] == "]" ) {
                    expresion[x] = ")"
                }
            }
        }
    }

    /**
     * Realiza la conversión de la notación infija a postfija
     * @return la expresión convertida a postfija
     */
    fun convertirAPostfijo(expresion: IList<String>): IList<String> {
        val pila: IStack<String> = TLinkedStack()
        val lista: IList<String> = TList()
        val lista_aux: IList<String> = TList()

        for (x in expresion){
            if (x=="("){
                lista_aux.add(x)
            }
            else if ((x=="+") ||(x=="-") || (x=="*") || (x=="/") || (x=="%")){
                pila.push(x)
            }

            else if (x==")"){
                val elemento=pila.peek()
                lista.add(elemento)
                pila.pop()

            }

            else{
                lista.add(x)
            }
        }


        return lista
    }

    /**
     * Realiza la evaluación de la expresión postfija almacenada en la lista
     * llamada "expresión". Realiza las operaciones de acuerdo al algoritmo
     * presentado.
     */
    fun evaluarExpresiónPostfija(expression: IList<String>): Int {
        val pila: IStack<Int> = TLinkedStack()
        var elemento_1=0
        var elemento_2= 0
        for (x in expression){
            var operacion=0
            if (x=="+"){
                elemento_2=pila.peek()
                pila.pop()
                elemento_1=pila.peek()
                pila.pop()
                operacion=elemento_1+elemento_2
                pila.push(operacion)
            }
            else if (x=="-"){
                elemento_2=pila.peek()
                pila.pop()
                elemento_1=pila.peek()
                pila.pop()
                operacion=elemento_1-elemento_2
                pila.push(operacion)
            }
            else if (x=="*"){
                elemento_2=pila.peek()
                pila.pop()
                elemento_1=pila.peek()
                pila.pop()
                operacion=elemento_1*elemento_2
                pila.push(operacion)
            }
            else if (x=="/"){
                elemento_2=pila.peek()
                pila.pop()
                elemento_1=pila.peek()
                pila.pop()
                operacion=elemento_1/elemento_2
                pila.push(operacion)
            }
            else if (x=="%"){
                elemento_2=pila.peek()
                pila.pop()
                elemento_1=pila.peek()
                pila.pop()
                operacion=elemento_1%elemento_2
                pila.push(operacion)
            }

            else{
                pila.push(x.toInt())
            }

        }


        return pila.peek()
    }



}

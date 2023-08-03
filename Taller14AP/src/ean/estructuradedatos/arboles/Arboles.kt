/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología de la Información y Comunicaciones
 * Faculta de Ingeniería
 *
 * Taller Árboles Binarios
 * Fecha: 5 de octubre de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.estructuradedatos.arboles

import ean.collections.IBinTree
import ean.collections.IList
import ean.collections.TList

/**
 * Informar si un elemento se encuentra presente en un árbol binario
 */
fun <T> estaArbin(a: IBinTree<T>, elem: T): Boolean =
    if (a.isEmpty){
        false
    }e
    else a.root == elem || estaArbin(a.left,elem) ||estaArbin(a.right,elem)
/**
 * Permite obtener el número de vocales que hay en el árbol
 */
fun contarVocales(arbol: IBinTree<String>): Int =
    if (arbol.isEmpty){
        0
    }
    else{
        var contador= contarVocales(arbol.left) + contarVocales(arbol.right)
        var palabra= arbol.root.toUpperCase()
        if (palabra=="A" ||palabra=="E" ||palabra=="I" ||palabra=="O" ||palabra=="U"){
            contador++
        }
        contador
    }

/**
 * Permite determinar cuantos elementos en el árbol son de dos dígitos y la suma de ambos dígitos es 7
 */
fun contarArbol(a: IBinTree<Int>): Int =
    if (a.isEmpty){
         0
    }
    else{
        var contador= contarArbol(a.left) + contarArbol(a.right)
        var numero= a.root
        if (((numero %10) + (numero / 10) == 7) && numero < 100){
            contador++
        }
        contador
    }

fun contarPares(a: IBinTree<Int>): Int {
    if (a.isEmpty){
        return 0
    }
    else{
        var contador= contarPares(a.left) + contarPares(a.right)
        var raiz= a.root
        if (raiz % 2 == 0){
            contador++
        }
        return contador
    }
}
/**
 * Permite conocer el porcentaje (entre 0 y 100) de pares en el árbol
 */
fun porcentajePares(a: IBinTree<Int>): Double {
    val contador = contarPares(a)
    val cantidadNum= peso(a)

    return (contador.toDouble() / cantidadNum.toDouble() * 100)
}

/**
 * Determinar la suma de los elementos pares del árbol
 */
fun sumaPares(arbol: IBinTree<Int>): Int =
    if (arbol.isEmpty){
        0
    }
    else{
        var raiz= arbol.root
        if (raiz % 2 == 0){
             sumaPares(arbol.left) + sumaPares(arbol.right) + raiz
        }
        else{
            sumaPares(arbol.left) + sumaPares(arbol.right)
        }

    }

/**
 * Obtener una lista con aquellos elementos del árbol que sean múltiplos de 6
 */
fun multiplosDeSeis(arbol: IBinTree<Int>): IList<Int> {
    if (arbol.isEmpty){
        return TList()
    }
    else{
        val multSeisIzq = multiplosDeSeis(arbol.left)
        val multSeisDer = multiplosDeSeis(arbol.right)
        var resp = multSeisIzq + multSeisDer
        if (arbol.root % 6 == 0){
            resp.add(arbol.root)
        }
        return resp

    }
}

/**
 *   Calcular el peso de un árbol binario
 */
fun <T> peso(a: IBinTree<T>): Int {
    if (a.isEmpty){
        return 0
    }

    else{
        var pesoArbol = peso(a.left) + peso(a.right)
        var raiz = a.root

        if (raiz != null){
            pesoArbol++
        }

        return pesoArbol
    }
}

/**
 * Esta función externa, NO ES RECURSIVA, y permite saber si el árbol a es una hoja o no.
 * Un árbol a es una hoja si no es vacio y el árbol izquierdo de a si es vacío y el árbol
 * derecho de a también es vacío. En cualquier otro caso, el árbol no es una hoja.
 */
fun <T> esUnaHoja(a: IBinTree<T>): Boolean =
    if (!a.isEmpty && (a.left.isEmpty) && (a.right.isEmpty)){
        true
    }
    else{
        false
    }

/**
 * Esta función externa y genérica SI es recursiva y cuenta el número de hojas. La definición
 * recursiva sería la siguiente:
 * - Si el árbol es vacío, no hay hojas
 * - Sino Si el árbol es una hoja, entonces hay 1 hoja
 * - Sino el número total de hojas que hay en el árbol es el número de hojas del árbol izquierdo más
 *        el número de hojas del árbol derecho.
 */
fun <T> contarHojas(a: IBinTree<T>): Int =
    if (a.isEmpty){
        0
    }
    else if (esUnaHoja(a)){
        1
    }
    else{
         (contarHojas(a.left) + contarHojas(a.right))
    }

/**
 * Permite obtener la altura de un árbol binario
 */
fun <T> altura(a: IBinTree<T>): Int =
    if (a.isEmpty){
         0
    }
    else{
        if (altura(a.right) > altura(a.left)){
             altura(a.right) + 1
        }
        else{
            altura(a.left) + 1
        }
    }


/**
 * Imprime el árbol binario a en preorden
 */
fun <T> preorden(a: IBinTree<T>): Unit {
    if (a.isEmpty){
        println()
    }
    else{
        print (a.root)
        preorden(a.left)
        preorden(a.right)
    }
}

/**
 * Imprime el árbol binario a en postorden
 */
fun <T> postorden(a: IBinTree<T>): Unit {
    if (a.isEmpty){
        println()
    }
    else{
        preorden(a.left)
        preorden(a.right)
        print (a.root)
    }
}


/**
 * Imprime el árbol binario a en inorden
 */
fun <T> inorden(a: IBinTree<T>) {
    if (a.isEmpty){
        println()
    }
    else{
        preorden(a.left)
        print (a.root)
        preorden(a.right)

    }
}

/**
 * Ayuda a determinar el nivel en que se encuentra un elemento. El algoritmo es el siguiente:
 * si el árbol está vacío, el nivel del elemento es -1
 * sino si el elemento es igual a la raíz del árbol a, el nivel del elemento es cero
 * sino si el elemento esta en el árbol izquierdo de a,
 *    el nivel del elemento es 1 + el nivel del elemento en el árbol izquierdo
 * sino si el elemento esta en el árbol derecho de a,
 *    el nivel del elemento es 1 + el nivel del elemento en el árbol derecho
 * sino
 *    retorne -1
 */
fun <T> nivelElementoArbol(a: IBinTree<T>, elem: T): Int =
    if (a.isEmpty){
        -1
    }
    else{
        var arbolizquierdo= a.left
        var arbolderecho = a.right
        if (a.root == elem){
            0
        }
        else if (estaArbin(arbolizquierdo,elem)){
            nivelElementoArbol(arbolizquierdo,elem) + 1
        }
        else if (estaArbin(arbolderecho,elem)){
            nivelElementoArbol(arbolderecho,elem) + 1
        }
        else{
            -1
        }
    }

/**
 * Obtiene el elemento padre del elemento e. Para hallar el papá tenemos el siguiente algoritmo
 * Si el árbol está vacío, el papá es nulo
 * sino si la raíz del árbol es igual al elemento, el papá es nulo también
 * sino si el izquierdo de a no es vacío y la raiz del izquierdo de a es igual al elemento, retorne la raiz de a
 * sino si el derecho de a no es vacío y la raiz del derecho de a es igual al elemento, retorne la raiz de a
 * sino si el elemento está en el árbol izquierdo de a, halle el papá del elemento e en el izquierdo de a
 * sino si el elemento está en el árbol derecho de a, halle el papá del elemento e en el árbol derecho de a
 * sino, retorne nulo.
 */
fun <T> padre(a: IBinTree<T>, e: T): T? =

    if (a.isEmpty || a.root == e){
        null
    }

    else{
        var arbolizquierdo= a.left
        var arbolderecho = a.right
        if ((!arbolizquierdo.isEmpty && arbolizquierdo.root == e) || (!arbolderecho.isEmpty && arbolderecho.root == e) ){
            a.root
        }
        else if (estaArbin(arbolizquierdo,e)){
            padre(arbolizquierdo,e)
        }
        else if (estaArbin(arbolderecho,e)){
            padre(arbolderecho,e)
        }
        else{
            null
        }
    }

/**
 * Esta función no es recursiva, pero es muy parecido al algoritmo de hallar el papá
 */
fun <T> hermanoElementoArbol(a: IBinTree<T>, elem: T): T? {
    return if (a.isEmpty || a.root == elem) {
        null
    }
    else if (!a.left.isEmpty && a.left.root == elem) {
        if (a.right.isEmpty) {
            null
        }
        else {
            a.right.root
        }
    }
    else if (!a.right.isEmpty && a.right.root == elem) {
        if (a.left.isEmpty) {
            null
        }
        else {
            a.left.root
        }
    }
    else {
        val hermano = hermanoElementoArbol(a.left, elem)
        hermano ?: hermanoElementoArbol(a.right, elem)
    }
}

/**
 *  Calcular cuantas veces aparece un elemento en un arbol
 */
fun <T> contarNumVecesApareceElemento(a: IBinTree<T>, e: T): Int =
    if (a.isEmpty){
         0
    }
    else{
        var contador= contarNumVecesApareceElemento(a.left,e) + contarNumVecesApareceElemento(a.right,e)
        var raiz= a.root
        if (raiz  == e){
            contador++
        }
        contador
    }

/**
 * Calcular el menor de un árbol binario. El Algoritmo es el siguiente
 * Si el árbol está vacío, digamos que el menor es un número grande, por ejemplo Int.MAX_VALUE
 * sino hay que retornar el menor entre la raíz, el menor del árbol izquierdo y el menor del árbol derecho
 */
fun menorDosElementos (a:Int?,b:Int?): Int {

    if (a != null && b == null){
        return a
    }
    else if (b != null && a == null){
        return b
    }
    else{
        if (a != null && b != null){
            if (a<b){
                return a
            }
            else{
                return b
            }
        }
        else{
            return Int.MAX_VALUE
        }

    }

}
fun menorArbol(arbol: IBinTree<Int>): Int =
    if (arbol.isEmpty){
        Int.MAX_VALUE
    }


    else{
        var menorIzquierdo = menorArbol(arbol.left)
        var menorDerecho = menorArbol(arbol.right)
        var menorIzDer = menorDosElementos(menorIzquierdo,menorDerecho)
        var menorArbolN= 0

        if (menorIzDer != null) {
            menorArbolN = menorDosElementos(menorIzDer, arbol.root)
        }
        else{
            menorArbolN =(arbol.root)
        }

        menorArbolN
    }









package ean.estructuradedatos.taller

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Funciones Recursivas
 * Fecha: 21 de septiembre de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.IList
import ean.collections.TList
import kotlin.math.absoluteValue

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Halla el factorial del número entero n
 * n! = n * (n-1) * (n-2) * ... * 2 * 1
 */
fun factorial(n: Int): Int =
    if (n==0 || n==1){
        1
    }
    else {
        n * factorial (n-1)
    }


/**
 * Halla el n-ésimo término de la serie de fibonacci
 */
fun fibonacci(n: Int): Int =
    if (n==1 || n==2){
        1
    }
    else {
        fibonacci(n-1) + fibonacci (n-2)
    }

/**
 * Permite determinar el término n,m del triángulo de Pascal
 * n = fila, m = término
 */
fun pascal(n: Int, m: Int): Int {
    if (m==1 || m==n+1){
        return 1
    }
    else{
        return pascal(n-1,m-1) +pascal(n-1,m)
    }
}
/**
 * Halla el valor de a^b =
 * si b es cero entonces retorne 1
 * sino retorne a multiplicado por elevar a a la b - 1
 */
fun elevar(a: Int, b: Int): Int =
    if (b==0){
        1
    }
    else{
        a * elevar (a,b-1)
    }

/**
 * Halla la suma de todos los números enteros entre 1 y n
 */
fun sumatoria(n: Int): Int =
    if (n==1){
        1
    }
    else{
        sumatoria(n-1) + n
    }

/**
 * Halla la suma de los cuadrados de los números de 1 hasta n
 */
fun sumaCuadrados(n: Int): Int =
    if (n==1){
        1
    }
    else{
        sumaCuadrados(n-1) + (n*n)
    }

/**
 * Hallar el valor de la serie 1/(2i+1) desde  1 hasta n
 */
fun serie(n: Int): Double =
    if (n==1){
        1.0/3.0
    }
    else{
        serie(n-1) + (1.0/(2.0*n+1.0))
    }

/**
 * Permite saber la cantidad de digitos que posee un número entero positivo n
 */
fun contarDigitos(n: Int): Int =
    if (n<10){
        1
    }
    else{
        contarDigitos(n/10) + 1
    }
/**
 * Permite hallar la suma de los dígitos de un número entero positivo n
 */
fun sumarDigitos(n: Int): Int =
    when{
        n<10 -> n
        else -> n%10 + sumarDigitos(n/10)
    }


/**
 * Un número entero positivo en múltiplo de 3 si:
 *  - tiene una cifra y es 0, 3, 6, o 9
 *  - tiene más de una cifra y la suma de sus dígitos es múltiplo de 3
 *  - en cualquier otro caso, el número no es múltiplo de 3
 *
 *  - NO PUEDEN USAR LA OPERACIÓN MÓDULO (%)
 */
fun esMultiploDe3(n: Int): Boolean =
    if (n<10 && (n==0 || n==3 || n==6 || n==9)){
        true
    }
    else if (n>=10 && esMultiploDe3(sumarDigitos(n))){
        true
    }
    else{
        false
    }

/**
 * Cuenta el número de dígitos pares que tiene un número entero positivo >= 1
 */
fun cantidadDigitosPares(n: Int): Int {
    if (n < 10){
        return if (n % 2 ==0){
            1
        }

        else{
        0
        }
    }
    else {
        val ult:Int= n%10
        val resto:Int= n/10
        val cantDigPares:Int= cantidadDigitosPares(resto)
        return if (ult % 2 == 0){
            cantDigPares + 1
        } else{
            cantDigPares
        }
    }
}



/**
 * Determina si el número dado es binario o no.
 * Los números binarios solo contienen los dígitos 1 y 0
 * Por ejemplo: el numero 100011110 es binario, pero 231 no lo es
 */
fun esNumeroBinario(n: Int): Boolean {
    if (n<10){
        if (n==0 || n===1){
            return true
        }
        else{
            return false
        }
    }
    else{
        val ult:Int= n%10
        val resto:Int= n/10
        val binarioUlt= esNumeroBinario(ult)
        val binarioResto=esNumeroBinario(resto)
        if (binarioUlt && binarioResto){
            return true
        }
        else{
            return false
        }
    }
}

/**
 * Permite saber si el número dado posee el dígito indicado
 */
fun poseeDigito(n: Int, digito: Int): Boolean {
    /*
    si el numero n posee un solo digito, entonces
       si n y el digito son iguales -> retorne true sino retorne false
    sino si el número n tiene más de un dígito, entonces
       si el ultimo dígito del número n es igual al dígito, entonces
         listo, lo encontramos, retorne true
       sino
         halle el resto de n
         mire si el resto de n posee el dígito indicado
     */
    if (n<10){
        if (n==digito){
            return true
        }
        else{
            return false
        }
    }
    else{
        val ult:Int= n%10
        val resto:Int= n/10
        val restoN= poseeDigito(resto,digito)
        if (ult==digito){
            return true
        }
        else if (restoN){
            return true
        }
        else{
            return false
        }

    }
}

/**
 * Retorna el dígito más grande que hace parte del número n
 * Ejemplo: el dígito más grande del númer 381704 es el 8
 * si el número tiene un solo dígito, el digito más grande es el numero
 * sino
 *    halle el resto y el último
 *    halla el digito mas grande del resto
 *    retorne el mayor entre el último y el dígito más grande del resto
 */
fun digitoMasGrande(n: Int): Int {
    if (n<10){
        return n
    }
    else{
        val ult:Int= n%10
        val resto:Int= n/10
        val mayorResto= digitoMasGrande(resto)
        if (ult>mayorResto){
            return ult
        }
        else{
            return mayorResto
        }

    }
}

/**
 * Imprimir cada elemento de la lista, pero de manera recursiva
 */
fun <T> imprimirLista(lista: IList<T>) {
    if (lista.isEmpty){
        println()
    }
    else{
        val primero = lista.head()
        val resto = lista.tail()
        print ("$primero")
        imprimirLista(resto)

    }
}

/**
 * Obtiene recursivamente la lista de los dígitos del número entero positivo n
 * Ejemplo: digitos(351804) == [3, 5, 1, 8, 0, 4]
 */
fun digitos(n: Int): IList<Int> {
    return if (n <10){
        TList(n)
    }
    else{
        val resto= n / 10
        val ultimo = n % 10
        val listaDigitosResto=digitos(resto)
        listaDigitosResto.add(ultimo)
        listaDigitosResto
    }
}

/**
 * Dado un número entero positivo >= 0, retorna una lista con la representación binaria
 * del número dado.
 * Ejemplo: convertirDecimalBinario(231) = List(1, 1, 0, 0, 1, 1, 1, 1, 1, 1)
 */
fun convertirDecimalBinario(n: Int): IList<Int> {

    if (n==1 || n==0){
        return TList(n)
    }
    else {
        val ultbinario= n % 2
        val resto = n / 2
        val listaBinResto= convertirDecimalBinario (resto)
        listaBinResto.add(ultbinario)
        return listaBinResto
    }
}

/**
 * Recursion con listas: Hallar la suma de los números pares de la lista que se recibe
 * como parámetro.
 * Ejemplo: sumarParesLista([40, 21, 8, 31, 6]) == 54
 */
fun sumarParesLista(lista: IList<Int>): Int {

    if (lista.isEmpty){
        return 0
    }


    else{
        val primero = lista.head()
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

/**
 * Recursión con listas: construir una función recursiva que retorne la posición del elemento en la lista
 * Si la lista está vacía, retorne -1. No se puede usar indexOf o lastIndexOf
 */
fun buscarElementoEnUnaLista(lista: IList<Int>, elem: Int): Int {
    if (lista.isEmpty){
        return -1
    }
    else{
        val primero = lista.head()
        val resto = lista.tail()


        if (primero == elem){
            return 0
        }
        else{
            val buscarResto= buscarElementoEnUnaLista(resto,elem)
            if (buscarResto!=-1){
                return buscarResto + 1
            }
            else{
                return -1
            }

        }

    }
}

/**
 * Traduce los diversos dígitos de la lista a un número entero
 * Ejemplo: convertirListaDigitosNumero([3, 4, 1, 7, 9]) == 34179
 */
fun convertirListaDigitosNumero(digitos: IList<Int>): Int {
    if (digitos.isEmpty){
        return 0
    }
    else{
        val primero = digitos.head()
        val resto = digitos.tail()
        val resultado = (primero * 10.0.pow(resto.size)+ convertirListaDigitosNumero(resto))
        return resultado.toInt()


    }
}

/**
 * Función genérica y recursiva que permite saber si un elemento está dentro
 * de la lista. No debe usarse la función indexOf o contains. Debe ser
 * recursiva. Para buscar un elemento hay que tener en cuenta
 * - si la lista está vacía, el elemento no está
 * - si el primero de la lista es igual al elemento, retornamos true (el elemento está)
 * - sino es igual al primero, entonces hay que ver si el elemento está en el resto de la lista
 */
fun <T> existeElemento(lista: IList<T>, elem: T): Boolean {
    if (lista.isEmpty){
        return false
    }
    else{
        val primero = lista.head()
        val resto = lista.tail()
        val existeResto = existeElemento(resto,elem)
        if (primero==elem){
            return true
        }
        else {
            return existeResto
        }
    }
}

/** Escribir una función recursiva que, sin usar pilas ni colas
 * ni ninguna otra lista, obtenga la misma lista, pero invertida
 */
fun invertirLista(lista: IList<Char>): IList<Char> {
    if (lista.size==1){
        return lista
    }
    else{
        val primero = lista.head()
        val resto = lista.tail()
        val invertirResto= invertirLista(resto)
        invertirResto.add(primero)
        return invertirResto

    }
}

/**
 * Una palabra es palíndrome si se lee igual de izquierda a derecha y de derecha
 * a izquierda. Esta función recibe la palabra (sin espacios) y de forma recursiva
 * determina si la palabra es palíndrome.
 */
fun esPalindrome(palabra: String): Boolean {
    if (palabra.length==1){
        return true
    }
    else {
        val primero= palabra.get(0)
        val ultimo = palabra.get(palabra.lastIndex)
        if (ultimo == primero){
            val palabraAfter=palabra.substring(1,palabra.lastIndex)
            return esPalindrome(palabraAfter)

        }
        else{
            return false
        }

    }
}

/**
 * Recursividad con listas. Escriba una función recursiva
 * Obtiene el número más grande de la lista. Si la lista está vacía retorne el número
 * entero más pequeño.
 */
fun mayorDeUnaLista(lista: IList<Int>): Int {
    if (lista.isEmpty){
        return 0
    }
    else{
        val primero = lista.head()
        val resto = lista.tail()
        val mayorResto = mayorDeUnaLista(resto)

        if (primero>mayorResto){
            return primero
        }
        else{
            return mayorResto
        }
    }
}


/**
 * Una clase auxiliar
 */
data class Punto(val x: Int, val y: Int) {
    fun distanciaAlOrigen(): Double = sqrt(x.toDouble().pow(2) + y.toDouble().pow(2))
}

/**
 * Recursivamente, obtener una lista con aquellos puntos que están en el origen o
 * que hacen parte del primer cuadrante.
 */
fun puntosPrimerCuadrante(puntos: IList<Punto>): IList<Punto> {
    if (puntos.isEmpty){
        return TList()
    }
    else{
        val primero: Punto = puntos.head()
        val resto:IList<Punto> = puntos.tail()
        val primerCuadranteResto:IList<Punto> = puntosPrimerCuadrante(resto)

        if (primero.x >=0 && primero.y >=0){
            primerCuadranteResto.add(primero)
            return primerCuadranteResto
        }
        else{
            return primerCuadranteResto
        }

    }
}

/**
 * Recursivamente, obtiene el punto que está más lejano del origen.
 * Si la lista esta vacía, retorne null
 * Si la lista tiene un solo elemento, retorne ese elemento
 * si la lista tiene más de un elemento, tome el primer elemento y
 * compárelo con el punto más lejano del resto de la lista.
 */
fun puntoMasLejano(puntos: IList<Punto>): Punto? {
    if (puntos.isEmpty){
        return null
    }
    else{
        val primero: Punto = puntos.head()
        val resto:IList<Punto> = puntos.tail()

        if (puntos.size == 1){
            return primero
        }
        else{
            val lejanoResto= puntoMasLejano(resto)
            val sumaPrimero= primero.x.absoluteValue + primero.y.absoluteValue
            val sumaLejanoResto = lejanoResto!!.x.absoluteValue + lejanoResto!!.y.absoluteValue

            if (sumaPrimero > sumaLejanoResto){
                return primero
            }
            else{
                return lejanoResto
            }
        }
    }
}

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Utils.java,v 1.0 2017/02/17 08:09 lacobo Exp $
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Ordenamiento
 * Autor: Universidad EAN - Octubre 28, 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.tallerordenamiento

import ean.collections.IList
import ean.collections.TList
import kotlin.math.ceil

/**
 * Aquí vamos a implementar los diversos algoritmos de Ordenamiento que usaremos para
 * ordenar la lista de empleados
 */
object AlgoritmosOrdenamiento {

    /**
     * Algoritmo de Burbuja. Usar el ordenamiento natural del objeto
     * Complejidad: O(n^2)
     */
    fun <T: Comparable<T>> bubbleSort(a: IList<T>): Unit {
        val n = a.size
        for (i in 0 until n-1){
            for (j in 0 until n-1){
                if (a[j] > a [j+1]){
                    var t= a[j]
                    a[j]= a[j+1]
                    a[j+1]= t
                }
            }
        }
    }

    /**
     * Algoritmo de Burbuja. Usar el ordenamiento natural del objeto
     * Complejidad: O(n^2)
     */
    fun <T> bubbleSort(a: IList<T>, c: Comparator<T>): Unit {
        val n = a.size
        repeat(n){
            for (j in 0 until n-1){
                if (c.compare(a[j],a[j+1]) > 0){
                    var t = a[j]
                    a[j]= a[j+1]
                    a[j+1] = t
                }
            }
        }
    }

    fun <T: Comparable<T>> selectionSort(a: IList<T>) {
        // Esta función encuentra la posición del menor, desde pos en adelante
        fun findPositionMinElem(pos: Int): Int {
            val n= a.size
            var menor=a[pos]
            var respuesta:Int=a.indexOf(menor)
            for (i in 0 until n-1){
                for (j in pos until n){
                    if (a[j] < menor ){
                        menor= a[j]
                        respuesta= a.indexOf(a[j])
                    }

                }
            }
            return respuesta
        }
        //-----------------------------------
        for (i in 0 until a.size-1) {
            val m = findPositionMinElem(i)
            if (i != m) {
                var t= a[i]
                a[i]= a[m]
                a[m]= t
            }
        }
    }

    fun <T> selectionSort(a: IList<T>, c: Comparator<T>) {
        // Esta función encuentra la posición del menor elemento desde pos, hasta el final de la lista
        fun findPositionMinElem(pos: Int): Int {
            val n= a.size
            var menor=a[pos]
            var respuesta:Int=a.indexOf(menor)
            for (i in 0 until n-1){
                for (j in pos until n){
                    if (c.compare(a[j],menor) < 0){
                        menor= a[j]
                        respuesta= a.indexOf(a[j])
                    }

                }
            }
            return respuesta
        }
        //-----------------------------------
        for (i in 0 until a.size-1) {
            val m = findPositionMinElem(i)
            if (i != m) {
                var t= a[i]
                a[i]= a[m]
                a[m]= t
            }
        }
    }



    fun <T: Comparable<T>> insertionSort(a: IList<T>) {
        val n= a.size
        for (i in 1 until n){
            var segundo= a[i]
            var primero=i-1

            while (primero >= 0 && segundo < a[primero] ){
                a[primero+1]= a[primero]
                primero -= 1
            }
            a[primero+1] = segundo
        }
    }

    fun <T> insertionSort(a: IList<T>, c:  Comparator<T>) {
        val n= a.size
        for (i in 1 until n){
            var segundo= a[i]
            var primero=i-1

            while (primero >= 0 && c.compare(segundo,a[primero]) < 0){
                a[primero+1]= a[primero]
                primero -= 1
            }
            a[primero+1] = segundo
        }
    }

    fun <T: Comparable<T>> mergeSort(a: IList<T>) {
        /**
         * Obtiene los elementos de la lista ubicados en la mitad inferior de la misma
         * es decir, en las posiciones desde la cero hasta la mitad de la lista
         */
        fun obtenerMitadInferior(lista: IList<T>): IList<T> {
            val n= lista.size
            val listaMitadInferior:IList<T> = TList()
            for (j in 0 until ceil((n/2.0)).toInt()){
                listaMitadInferior.add(lista[j])

            }

            return listaMitadInferior
        }

        /**
         * Obtiene los elementos de la lista ubicados en la mitad superior de la misma
         * es decir, en las posiciones desde la mitad + 1 hasta el final de la lista
         */
        fun obtenerMitadSuperior(lista: IList<T>): IList<T> {
            val n= lista.size
            val listaMitadSuperior:IList<T> = TList()
            for (j in ceil((n/2.0) ).toInt() until n ){
                listaMitadSuperior.add(lista[j])

            }

            return listaMitadSuperior
        }

        /**
         * Retorna la mezcla ordenada de las listas a y b
         */
        fun mezclarListas(a: IList<T>, b: IList<T>): IList<T> {
            var l3: IList<T> = TList()
            var indiceA:Int = 0
            var indiceB:Int = 0

            while (!a.isEmpty && !b.isEmpty){
                if (a[indiceA] < b[indiceB]){
                    l3.add(a[indiceA])
                    a.remove(indiceA)

                }
                else{
                    l3.add(b[indiceB])
                    b.remove(indiceB)
                }
            }
            if (!a.isEmpty){
                l3.addAll(a)
            }
            else if (!b.isEmpty){
                l3.addAll(b)
            }

            return l3
        }

        //------------------------------------------------------------------------------
        // Función Principal del MergeSort
        //------------------------------------------------------------------------------
        if (a.size >= 2) {
            if (a.size == 2) {
                if (a[0] > a[1]) {

                    val t= a[0]
                    a[0]= a[1]
                    a[1]= t
                }
            }
            else {
                // Algoritmo MergeSort.

                // 1. Particione la lista en dos mitades
                val p: IList<T> = obtenerMitadInferior(a)
                val q: IList<T> = obtenerMitadSuperior(a)

                // 2. ordene cada mitad usando mergesort
                mergeSort(p)
                mergeSort(q)

                // 3. Mezcle las dos listas ordenadas y copielas a la lista de resultado
                val resultado = mezclarListas(p, q)
                a.clear()
                a.addAll(resultado)
            }
        }
    }

    fun <T> mergeSort(a: IList<T>, c: Comparator<T>) {
        /**
         * Obtiene los elementos de la lista ubicados en la mitad inferior de la misma
         * es decir, en las posiciones desde la cero hasta la mitad de la lista
         */
        fun obtenerMitadInferior(lista: IList<T>): IList<T> {
            val n= lista.size
            val listaMitadInferior:IList<T> = TList()
            for (j in 0 until ceil((n/2.0)).toInt()){
                listaMitadInferior.add(lista[j])

            }

            return listaMitadInferior
        }

        /**
         * Obtiene los elementos de la lista ubicados en la mitad superior de la misma
         * es decir, en las posiciones desde la mitad + 1 hasta el final de la lista
         */
        fun obtenerMitadSuperior(lista: IList<T>): IList<T> {
            val n= lista.size
            val listaMitadSuperior:IList<T> = TList()
            for (j in ceil((n/2.0) ).toInt() until n ){
                listaMitadSuperior.add(lista[j])

            }

            return listaMitadSuperior
        }

        /**
         * Retorna la mezcla ordenada de las listas a y b
         */
        fun mezclarListas(a: IList<T>, b: IList<T>): IList<T> {
            var l3: IList<T> = TList()
            var indiceA:Int = 0
            var indiceB:Int = 0

            while (!a.isEmpty && !b.isEmpty){

                if ( c.compare(a[indiceA],b[indiceB]) < 0){
                    l3.add(a[indiceA])
                    a.remove(indiceA)

                }
                else{
                    l3.add(b[indiceB])
                    b.remove(indiceB)
                }
            }
            if (!a.isEmpty){
                l3.addAll(a)
            }
            else if (!b.isEmpty){
                l3.addAll(b)
            }

            return l3
        }

        //------------------------------------------------------------------------------
        // Función Principal del MergeSort
        //------------------------------------------------------------------------------
        if (a.size >= 2) {
            if (a.size == 2) {

                if (c.compare(a[0],a[1]) > 0) {
                    var t= a[0]
                    a[0]= a[1]
                    a[1]= t
                }
            }
            else {
                // Algoritmo MergeSort.

                // 1. Particione la lista en dos mitades
                val p: IList<T> = obtenerMitadInferior(a)
                val q: IList<T> = obtenerMitadSuperior(a)

                // 2. ordene cada mitad usando mergesort
                mergeSort(p,c)
                mergeSort(q,c)

                // 3. Mezcle las dos listas ordenadas y copielas a la lista de resultado
                val resultado = mezclarListas(p, q)
                a.clear()
                a.addAll(resultado)
            }
        }
    }

    fun <T: Comparable<T>> quickSort(a: IList<T>) {
        /**
         * Obtener los elementos inferiores al pivote de la lista a
         */
        fun menoresAlPivote(a: IList<T>, pivote: T): IList<T> {
            val n= a.size
            val listaMenoresAlPivote:IList<T> = TList()
            for (i in 0 until n){
                if (a[i] < pivote){
                    listaMenoresAlPivote.add(a[i])
                }
            }
            return listaMenoresAlPivote
        }

        /**
         * Obtener los elementos superiores o iguales al pivote en la lista
         */
        fun mayoresAlPivote(a: IList<T>, pivote: T): IList<T> {
            val n= a.size
            val listaMayoresAlPivote:IList<T> = TList()
            for (i in 0 until n){
                if (a[i] > pivote){
                    listaMayoresAlPivote.add(a[i])
                }
            }
            return listaMayoresAlPivote
        }

        //-----------------------------------------------------------------
        // Función Principal
        //-----------------------------------------------------------------
        if (a.size >= 2) {
            if (a.size == 2) {
                if (a[0] > a[1]) {

                    var t= a[0]
                    a[0]= a[1]
                    a[1]= t
                }
            }
            else {
                // Algoritmo QuickSort

                // 1. Obtener el pivote, en este caso puede ser el primer elemento
                val pivote = a[0]

                // 2. Obtener los menores y los mayores al pivote
                val mayores = mayoresAlPivote(a, pivote)
                val menores = menoresAlPivote(a, pivote)

                // 3. Ordene estas dos ultimas listas usando el quicksort
                quickSort(mayores)
                quickSort(menores)

                // 4. Ahora pegamos los pedazos junto con el pivote
                a.clear()
                a.addAll(menores)
                a.add(pivote)
                a.addAll(mayores)
            }
        }
    }

    fun <T> quickSort(a: IList<T>, c: Comparator<T>) {
        /**
         * Obtener los elementos inferiores al pivote de la lista a
         */
        fun menoresAlPivote(a: IList<T>, pivote: T): IList<T> {
            val n= a.size
            val listaMenoresAlPivote:IList<T> = TList()
            for (i in 0 until n){
                if (c.compare(a[i],pivote) < 0){
                    listaMenoresAlPivote.add(a[i])
                }
            }
            return listaMenoresAlPivote
        }

        /**
         * Obtener los elementos superiores o iguales al pivote en la lista
         */
        fun mayoresAlPivote(a: IList<T>, pivote: T): IList<T> {
            val n= a.size
            val listaMayoresAlPivote:IList<T> = TList()
            for (i in 0 until n){
                if (c.compare(a[i],pivote) > 0){
                    listaMayoresAlPivote.add(a[i])
                }
            }
            return listaMayoresAlPivote
        }

        //-----------------------------------------------------------------
        // Función Principal
        //-----------------------------------------------------------------
        if (a.size >= 2) {
            if (a.size == 2) {

                if (c.compare(a[0],a[1]) > 0) {

                    var t= a[0]
                    a[0]= a[1]
                    a[1]= t
                }
            }
            else {
                // Algoritmo QuickSort

                // 1. Obtener el pivote, en este caso puede ser el primer elemento
                val pivote = a[0]

                // 2. Obtener los menores y los mayores al pivote
                val mayores = mayoresAlPivote(a, pivote)
                val menores = menoresAlPivote(a, pivote)

                // 3. Ordene estas dos ultimas listas usando el quicksort
                quickSort(mayores,c)
                quickSort(menores,c)

                // 4. Ahora pegamos los pedazos junto con el pivote
                a.clear()
                a.addAll(menores)
                a.add(pivote)
                a.addAll(mayores)
            }
        }
    }


}



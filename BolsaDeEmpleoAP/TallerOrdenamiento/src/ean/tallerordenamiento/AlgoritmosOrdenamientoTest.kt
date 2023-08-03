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
import ean.tallerordenamiento.AlgoritmosOrdenamiento.bubbleSort
import ean.tallerordenamiento.AlgoritmosOrdenamiento.insertionSort
import ean.tallerordenamiento.AlgoritmosOrdenamiento.mergeSort
import ean.tallerordenamiento.AlgoritmosOrdenamiento.quickSort
import ean.tallerordenamiento.AlgoritmosOrdenamiento.selectionSort
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class AlgoritmosOrdenamientoTest {

    fun crearListaAleatoria(size: Int): IList<Int> {
        val resultado: IList<Int> = TList()

        fun aleat(): Int {
            while (true) {
                val num = Random.nextInt(1000)
                if (num !in resultado) {
                    return num
                }
            }
        }

        repeat(size) {
            resultado.add(aleat())
        }
        return resultado
    }

    @Test
    fun burbuja() {
        var lista = crearListaAleatoria(20)
        print("Lista original: $lista")
        bubbleSort(lista)
        println("Lista ordenada: $lista")

        val comparador = Comparator<Int>  {
            n1, n2 ->
                when {
                    n1 == n2 -> 0
                    n1 < n2  ->1
                    else -> -1
                }
        }

        bubbleSort(lista, comparador)
        println("Lista ordenada: $lista")


    }
    @Test
    fun insertion() {
        var lista = crearListaAleatoria(5)
        print("Lista original: $lista")
        insertionSort(lista)
        println("Lista ordenada: $lista")

        val comparador = Comparator<Int>  {
                n1, n2 ->
            when {
                n1 == n2 -> 0
                n1 < n2  ->1
                else -> -1
            }
        }

        insertionSort(lista, comparador)
        println("Lista ordenada: $lista")


    }

    @Test
    fun merge() {
        var lista = crearListaAleatoria(5)
        print("Lista original: $lista")
        mergeSort(lista)
        println("Lista ordenada: $lista")

        val comparador = Comparator<Int>  {
                n1, n2 ->
            when {
                n1 == n2 -> 0
                n1 < n2  ->1
                else -> -1
            }
        }

        mergeSort(lista, comparador)
        println("Lista ordenada: $lista")


    }
    @Test
    fun selection() {
        var lista = crearListaAleatoria(5)
        print("Lista original: $lista")
        selectionSort(lista)
        println("Lista ordenada: $lista")

        val comparador = Comparator<Int>  {
                n1, n2 ->
            when {
                n1 == n2 -> 0
                n1 < n2  ->1
                else -> -1
            }
        }

        selectionSort(lista, comparador)
        println("Lista ordenada: $lista")


    }
    @Test
    fun quick() {
        var lista = crearListaAleatoria(5)
        print("Lista original: $lista")
        quickSort(lista)
        println("Lista ordenada: $lista")

        val comparador = Comparator<Int>  {
                n1, n2 ->
            when {
                n1 == n2 -> 0
                n1 < n2  ->1
                else -> -1
            }
        }

        quickSort(lista,comparador)
        println("Lista ordenada: $lista")


    }
}

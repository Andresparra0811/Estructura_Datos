/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Proyecto EAN Java Collections
 * Autor: Luis Cobo - Sept 3, 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.tallerimplementacioncolas

import ean.collections.TArray

/**
 * Implementación de las Colas (IQueue) pero utilizando arreglos circulares
 *
 */
class ColaConArreglos: IQueue<Int> {
    //---------------------------------------------------------
    // Constantes
    //---------------------------------------------------------
    /**
     * Tamaño inicial del arreglo circular
     */
    private val CAPACIDAD_INICIAL = 100

    //--------------------------------------
    // Atributos
    //--------------------------------------

    /**
     * Arreglo circular para los elementos de la cola
     */
    private var datos: TArray<Int> = TArray(initialCapacity = CAPACIDAD_INICIAL)

    /**
     * El indice del elemento que se encuentra en el tope de la pila
     */
    private var inicio: Int = -1

    /**
     * Posición donde se encuentra el elemento en la cola de la cola
     */
    private var fin: Int = -1

    /**
     * Número total de datos en el arreglo
     */
    private var tam: Int = 0

    //---------------------------------------------
    // Constructor
    //---------------------------------------------

    /**
     * Crea una cola vacía
     */
    constructor()

    //---------------------------------------------------------
    // Métodos
    //---------------------------------------------------------
    override val isEmpty: Boolean
        get() = tam == 0
    override val front: Int
        get() = datos [inicio]


    override fun enqueue(element: Int) {
        require (tam<CAPACIDAD_INICIAL)
        fin=(fin+1) % CAPACIDAD_INICIAL
        datos [fin]= element
        tam ++
        if (inicio == - 1 ){
            inicio=0
        }
    }

    override fun dequeue(): Int {
       require (tam > 0 )
        val elem:Int = datos [inicio]
        inicio= (inicio+1)% CAPACIDAD_INICIAL
        tam --
        return elem
    }

    override fun copy(): IQueue<Int> {
        val copia = ColaConArreglos()
        val aux = ColaConArreglos()

        while (!this.isEmpty){
            copia.enqueue(this.front)
            aux.enqueue(this.front)
            this.dequeue()
        }
        while (!aux.isEmpty){
            this.enqueue(aux.front)
            aux.dequeue()
        }
        return copia
    }

    override fun clear() {
        tam=0
        inicio=-1
        fin=-1
    }
}

/**
 * Pruebas de la clase Cola
 */
fun main() {
    // Creamos una cola vacía
    val miCola: IQueue<Int> = ColaConArreglos()

    // Imprimimos la cola
    imprimirCola(miCola)

    // Insertamos algunos elementos en la cola
    miCola.enqueue(10)
    miCola.enqueue(20)
    miCola.enqueue(30)
    miCola.enqueue(40)

    // Volvemos a mostrar la cola
    imprimirCola(miCola)

    // Eliminamos los primeros dos elementos de la cola
    miCola.dequeue()
    miCola.dequeue()

    // Ahora volvemos a imprimir la cola
    imprimirCola(miCola)

    // Imprimimos otra vez el frente de la cola
    println("El que está al frente de la cola es ${miCola.front}")

}

private fun imprimirCola(cola: IQueue<Int>) {
    if (cola.isEmpty) {
        println("La cola está")
    }
    else {
        val copia = cola.copy()

        while (!copia.isEmpty) {
            print("${copia.front} <--- ")
            copia.dequeue()
        }
        println()
    }
}
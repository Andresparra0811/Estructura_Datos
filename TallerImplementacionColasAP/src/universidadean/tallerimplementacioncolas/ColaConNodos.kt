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

/**
 * Implementación de las colas como un conjunto de nodos
 * doblemente encadenados
 */
class ColaConNodos: IQueue<Int> {
    //--------------------------------------
    // Atributos
    //--------------------------------------
    /**
     * La cabeza de la cola. El primer elemento de la misma.
     */
    private var primero: Nodo? = null

    /**
     * El último elemento de la cola.
     */
    private var ultimo: Nodo? = null

    //-------------------------------------------------
    // Constructor
    //-------------------------------------------------

    /**
     * Crea una cola vacía
     */
    constructor()

    //-------------------------------------------------
    // Métodos
    //-------------------------------------------------
    override val isEmpty: Boolean
        get() = primero== null &&  ultimo==null
    override val front: Int
        get() = primero!!.info
 
    override fun enqueue(element: Int) {
        val nodito=Nodo(element)
        if (this.isEmpty){
            ultimo=nodito
            primero=nodito
        }
        else {
            ultimo!!.sig=nodito
            ultimo=nodito
        }
    }

    override fun dequeue(): Int {
        var frente=this.front
        primero=primero!!.sig
        if (primero==null){
            ultimo=null
        }
        return frente
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
        primero =null
        ultimo=null
    }

    /**
     * Clase Nodo que se utilizará para almacenar la información de los elementos de la cola
     */
    internal class Nodo(var info: Int, var sig: Nodo? = null)
}

/**
 * Pruebas de la clase Cola
 */
fun main() {
    // Creamos una cola vacía
    val miCola: IQueue<Int> = ColaConNodos()

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
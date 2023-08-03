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
 * Una Cola (Queue en inglés) es una estructura de datos que permite almacenar la información de forma lineal, y que
 * ofrece la posibilidad de trabajar bajo el esquema FIFO (el primero que entra es el primero que sale - First In,
 * First Out). Las colas ofrecen la posibilidad de ingresar información por un lado y consultar información por el otro
 * lado de la estructura lineal.
 */
interface IQueue<T> {
    /**
     * Permite saber si la cola esta vacía.
     * @return true si la cola está vacía y false sino es así.
     */
    val isEmpty: Boolean

    /**
     * Permite conocer el elemento en el frente o cabeza de la cola.
     * @return el elemento al frente de la cola
     */
    val front: T

    /**
     * Inserta un elemento al final de la cola.
     * @param element el elemento a agregar a la cola
     */
    fun enqueue(element: T)

    /**
     * Elimina el elemento que se encuentra en el tope de la cola
     * @return el elemento que estaba previamente en el tope
     */
    fun dequeue(): T

    /**
     * Permite obtener una copia idéntica de la cola actual.
     * @return una cola idéntica a la cola actual
     */
    fun copy(): IQueue<T>

    /**
     * Limpia la cola. Deja la cola totalmente vacía.
     */
    fun clear()
}
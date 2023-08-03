/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 * <p>
 * Proyecto Taller con el TAD Cola
 * Autor: Luis Cobo - Sep 08 - 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.colas

import ean.collections.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test


/**
 * Desarrolle las diversas operaciones de las colas que se encuentran en
 * esta clase. No olvide probar los diversos métodos implementados.
 */

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * Crea una copia idéntica de la cola que se recibe como parámetro.
 * OJO: No se puede usar el método copy() de las colas. Pueden usar
 * una lista, pila u otra cola como ayuda,
 */
fun <T> copiarCola(cola: IQueue<T>): IQueue<T> {
    val copia:IQueue<T> = TLinkedQueue()
    val aux:IQueue<T> = TLinkedQueue()

    while (!cola.isEmpty){
        val e = cola.front
        copia.enqueue(e)
        aux.enqueue(e)
        cola.dequeue()
    }

    while (!aux.isEmpty){
        cola.enqueue(aux.front)
        aux.dequeue()
    }

    return copia

}

/**
 * Obtiene la cantidad de elementos que hacen parte de la cola.
 * Es un método genérico y la cola original no debe
 * verse modificada. Obtenga y trabaje con una copia de la cola.
 */
fun <T> tamañoCola(cola: IQueue<T>): Int {
    val copia= cola.copy()
    var cont=0
    while(!copia.isEmpty){
        cont++
        copia.dequeue()
    }
    return cont
}

/**
 * En una cola de String, permite saber la posición de un elemento.
 * Debe tenerse en cuenta que el elemento que
 * está al frente o la cima de la cola está en la posición cero.
 * Si el elemento no está en la cola, deberá
 * retornarse -1. La cola original no debe verse modificada.
 */

fun posicionElementoCola(cola: IQueue<String>, elemento: String): Int {
    var posicion=-1
    var frente=false
    val copy:IQueue<String> = cola.copy()
    while(!copy.isEmpty){
        if (copy.front==elemento){
            posicion += 1
            frente=true
            break
        }
        copy.dequeue()
        posicion += 1
    }
    if(!frente){
        posicion=-1
    }
    return posicion
}

/**
 * Invierte el contenido de la cola. La cola original no debe verse modificado.
 * Use una pila o una lista para
 * llevar a cabo el proceso de inversión.
 * Si la cola es [4, 5, 11, 8, 3], el inverso debe ser [3, 8, 11, 5, 4]
 */
fun invertirCola(cola: IQueue<Int>): IQueue<Int> {
    val copia:IQueue<Int> = cola.copy()
    val pila: IStack<Int> = TLinkedStack()
    while(!copia.isEmpty){
        pila.push(copia.front)
        copia.dequeue()
    }
    while (!pila.isEmpty){
        copia.enqueue(pila.peek())
        pila.pop()
    }
    return copia
}

/**
 * Permite saber el elemento que se encuentra en el fondo de la cola.
 * La cola original no debe verse afectada. La
 * cola nunca va a estar vacía.
 */

fun <T> fondoCola(cola: IQueue<T>): T {
    val copy:IQueue<T> = cola.copy()
    val pila: IStack<T> = TLinkedStack()
    while(!copy.isEmpty){
        pila.push(copy.front)
        copy.dequeue()
    }
    return pila.peek()
}

/**
 * Deja a la cola cambiada sin el elemento que se encuentra en el fondo de la misma.
 * La cola original se debe ver * modificada. No se retorna nada. La cola nunca es vacía
 */
fun <T> eliminarFondoCola(cola: IQueue<T>) {
    var lista_auxiliar: IList<T> = TList()
    while(!cola.isEmpty){
        lista_auxiliar.add(cola.front)
        cola.dequeue()
    }
    for (elemento in 0 until lista_auxiliar.size-1){
        cola.enqueue(lista_auxiliar[elemento])
    }
}

/**
 * Suponga que tenemos en una cola los nombres de un grupo de personas.
 * Por simplicidad hemos decidido que los
 * nombres que correspondan a mujeres terminan en las letras 'a' o 'e'.
 * Se necesita que se retorne el nombre de
 * mujer más largo de la cola. La cola original no debe verse modificada.
 */
fun nombreMujerMasLargo(nombres: IQueue<String>): String {
    val copia: IQueue<String> = nombres.copy()
    var mayorLetras=0
    var nombreMayor=""
    while (!copia.isEmpty){
        var elemento=copia.front
        var letra=""
        var numLetras=0
        for (x in elemento){
            letra=x.toString()
            numLetras++
        }
        if (letra=="e"||letra=="a"){
            if(numLetras>mayorLetras){
                nombreMayor=elemento
                mayorLetras=numLetras
            }
        }
        copia.dequeue()
    }
    return nombreMayor
}


/**
 * Agrega el elemento elem en la posición pos de la cola, desplazando todos
 * los elementos siguientes una posición hacia el final. La cola original
 * se ve modificada después de agregar el elemnto. La posicion es válida, es decir,
 * está siempre entre cero y tamaño - 1 de la cola.
 */
fun <T> colarElemento(cola: IQueue<T>, pos: Int, elemento: T) {
    var listaAuxiliar:IList<T> =TList()
    var x=0
    while (!cola.isEmpty ){
        if (x==pos){
            listaAuxiliar.add(elemento)
            x=x+1
        }
        listaAuxiliar.add(cola.front)
        cola.dequeue()
        x=x+1
    }
    for (x in listaAuxiliar){
        cola.enqueue(x)
    }
}

/**
 * Deja en la cola colaMenores todos los elementos de la cola
 * que sean menores o iguales al elem, y en la cola
 * colaMayores, los elementos que sean mayores al elemento elem.
 * La cola original no debe verse modificada. Las
 * colas colaMenores y colaMayores están creadas y estan vacías.
 */
fun partirCola(cola: IQueue<Int>, colaMenores: IQueue<Int>, colaMayores: IQueue<Int>, elem: Int) {
    val copy: IQueue<Int> = cola.copy()
    while(!copy.isEmpty){
        val elemento=copy.front
        if(elemento<=elem){
            colaMenores.enqueue(elemento)
        }
        else{
            colaMayores.enqueue(elemento)
        }
        copy.dequeue()
    }
}

/**
 * Retorna una nueva cola con el mismo contenido de la cola original,
 * solo que el elemento elem ha sido eliminado
 * de la cola tantas veces como aparezca. La cola original no debe
 * verse modificada.
 */
fun <T> eliminarElementoCola(cola: IQueue<T>, elem: T): IQueue<T> {
    var copia:IQueue<T> = cola.copy()
    var colaN:IQueue<T> = TLinkedQueue()
    while (!copia.isEmpty ){
        if (copia.front!=elem){
            colaN.enqueue(copia.front)
        }
        copia.dequeue()
    }
    return colaN
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class PruebasColas {
    //-------------------------------------------------
    // Atributos del archivo de pruebas
    //-------------------------------------------------
    private lateinit var colaNumeros: IQueue<Int>
    private lateinit var colaNombres: IQueue<String>

    /**
     * Crea la cola llena de nombres de personas
     */
    private fun configurarColaNombres() {
        val lst = TList(
            "juana", "daniela", "silene", "marcos", "brayant", "leonidas", "harry",
            "hermione", "ron", "teresa", "sofia", "sovio", "antonio", "maria", "marcela", "remigia",
            "mercedita", "manuela", "diana", "hermenegildo", "mateo", "carlos", "carolina", "pedro"
        )
        colaNombres = TLinkedQueue()
        for (elem in lst) {
            colaNombres.enqueue(elem)
        }
    }

    /**
     * Crea una cola llena con números enteros
     */
    private fun configurarColaNúmeros() {
         val lst = TList(80, 31, 20, 112, 28, 1, 45, 72, 77, 81, 96, 965, 175, 217, 892, 745, 65, 616)
        colaNumeros = TLinkedQueue()
        for (elem in lst) {
            colaNumeros.enqueue(elem)
        }
    }

    /**
     * Función que crea una cola a partir de argumentos variable
     */
    fun <T> Queue(vararg elems: T): IQueue<T> {
        val res = TLinkedQueue<T>()
        for (elem in elems) {
            res.enqueue(elem)
        }
        return res
    }

    @Test
    open fun pruebaCopiarCola() {

        // Creamos una cola de números y la llenamos
        val cola1: IQueue<Int> = TLinkedQueue()
        cola1.enqueue(10)
        cola1.enqueue(8)
        cola1.enqueue(3)
        cola1.enqueue(6)
        cola1.enqueue(20)
        cola1.enqueue(1)
        println("La cola original es: $cola1")

        // Ahora creamos una copia de la cola anterior
        val cola2 = copiarCola(cola1)
        println("La copia de la cola es: $cola2")
        assertEquals(cola1, cola2)

        // Agregamos un elemento nuevo a la copia, y verificamos que las colas no quedan iguales
        cola2.enqueue(30)
        assertNotEquals(cola1, cola2)
        println("Prueba superada!")
    }

    @Test
    fun pruebaTamañoCola() {
        // Creamos dos colas: de nombres y de números
        configurarColaNombres()
        configurarColaNúmeros()

        // Obtenemos los tamaños
        val tamNoms = tamañoCola(colaNombres)
        val tamNums = tamañoCola(colaNumeros)
        println("Tam Cola Nombres = " + tamañoCola(colaNombres))
        println("Tam Cola Numeros = " + tamañoCola(colaNumeros))

        // Verificamos los valores de los métodos anteriores
        assertEquals(24, tamNoms, "El tamaño de la cola de nombres es incorrecto!")
        assertEquals(18, tamNums, "El tamaño de la cola de números está mal!")

        // Mensaje final
        println("Prueba de tamañoCola superada!")
    }

    /**
     * Probar el metodo posicionElementoCola
     */
    @Test
    fun pruebaPosicionElementoCola() {
        // Configuramos la cola
        configurarColaNombres()

        // Obtenemos las posiciones de ciertos nombres
        val posElena = posicionElementoCola(colaNombres, "elena")
        val posMaria = posicionElementoCola(colaNombres, "maria")

        // Verificamos las posiciones de los nombres encontrados
        assertEquals(-1, posElena, "La posicion del nombre 'elena' está mal")
        assertEquals(13, posMaria, "La posicion del nombre 'maria' está mal")

        // Mensaje final
        println("Prueba posicionElementoCola superada!")
    }

    /**
     * Probar el metodo invertir la cola
     */
    @Test
    fun pruebaInvertirCola() {
        // Creamos una cola con numeros enteros
        val cola: IQueue<Int> = TLinkedQueue()
        cola.enqueue(25)
        cola.enqueue(12)
        cola.enqueue(8)
        cola.enqueue(44)
        cola.enqueue(65)
        cola.enqueue(5)
        cola.enqueue(94)

        // Ahora procedemos a invertir la cola
        val colaInvertida: IQueue<Int> = invertirCola(cola)

        // Imprimimos la cola y la cola invertida
        println("La cola original es:  $cola")
        println("La cola invertida es: $colaInvertida")

        // Verificamos que las cosas queden iguales
        val prueba: IQueue<Int> = Queue(94, 5, 65, 44, 8, 12, 25)
        assertEquals(prueba, colaInvertida)

        // Mensaje final
        println("Prueba invertirCola superada!")
    }

    /**
     * Probar el fondo de la cola
     */
    @Test
    fun probarFondoCola() {
        // Creamos las colas
        configurarColaNombres()
        configurarColaNúmeros()

        // Obtenemos los fondos de ambas colas
        val fondoNombres = fondoCola(colaNombres)
        val fondoNumeros = fondoCola(colaNumeros)

        // Verificamos que los datos estén correctos
        assertEquals("pedro", fondoNombres, "El fondo de la cola de nombres está incorrecto!")
        assertEquals(616, fondoNumeros, "El fondo de la cola de numeros está mal!")

        // Mensaje final
        println("Prueba fondo Cola superada!")
    }

    /**
     * Probamos eliminar el fondo de la cola
     */
    @Test
    fun probarEliminarFondoCola() {
        // Creamos una cola de caracteres
        val letras = Queue('n', 'o', 'd', 'e', 'j', 's')

        // Elimina el fondo
        eliminarFondoCola(letras)

        // Verificamos el contenido de la cola
        val sinLaUltimaLetra = Queue('n', 'o', 'd', 'e', 'j')
        assertEquals(sinLaUltimaLetra, letras)

        // Mensaje final
        println("Prueba eliminar fondocola superada!")
    }

    /**
     * Probamos el obtener el nombre mas largo
     */
    @Test
    fun probarNombreMasLargo() {
        // Creamos una cola con los nombres
        configurarColaNombres()

        // Obtenemos el nombre de mujer mas largo de la cola
        val nombreMasLargo = nombreMujerMasLargo(colaNombres)

        // Verificamos el nombre de mujer mas largo obtenido sea el correcto
        assertEquals("mercedita", nombreMasLargo, "El nombre de mujer mas largo no es correcto!")
    }

    /**
     * Prueba el método de cola un elemento en una cola
     */
    @Test
    fun probarColar() {
        // Creamos una cola con numeros
        configurarColaNúmeros()

        // Encolamos un elemento al principio
        colarElemento(colaNumeros, 0, 33)
        var cola: IQueue<Int> = Queue(33, 80, 31, 20, 112, 28, 1, 45, 72, 77, 81, 96, 965, 175, 217, 892, 745, 65, 616)
        assertEquals(cola, colaNumeros, "El elemento 33 no quedó bien agregado en la cola")

        // Encolamos un elemento en la mitad
        configurarColaNúmeros()
        colarElemento(colaNumeros, 7, 1000)
        cola = Queue(80, 31, 20, 112, 28, 1, 45, 1000, 72, 77, 81, 96, 965, 175, 217, 892, 745, 65, 616)
        assertEquals(cola, colaNumeros, "El elemento 1000 no quedó bien agregado en la cola!")

        // Intentamos agregarlo antes del ultimo
        configurarColaNúmeros()
        colarElemento(colaNumeros, 17, 714)
        cola = Queue(80, 31, 20, 112, 28, 1, 45, 72, 77, 81, 96, 965, 175, 217, 892, 745, 65, 714, 616)
        assertEquals(cola, colaNumeros, "El elemento 714 no quedó insertado en el lugar adecuado!")

        // Mensaje final
        println("Prueba colarElemento superada!!")
    }

    /**
     * Probar el método de partirCola
     */
    @Test
    fun probarPartirCola() {
        // Las colas repositorias de los elementos
        val colaMenores: IQueue<Int> = TLinkedQueue()
        val colaMayores: IQueue<Int> = TLinkedQueue()

        // Creamos una cola de números
        configurarColaNúmeros()

        // Partimos la cola de numeros por el número 200
        partirCola(colaNumeros, colaMenores, colaMayores, 200)

        // Verificamos los contenidos y el buen funcionamiento del método
        val menores = Queue(80, 31, 20, 112, 28, 1, 45, 72, 77, 81, 96, 175, 65)
        val mayores = Queue(965, 217, 892, 745, 616)
        assertEquals(menores, colaMenores, "La cola de los menores de 200 está mal!")
        assertEquals(mayores, colaMayores, "La cola de los mayores de 200 está mal!")

        // Mensaje final
        println("prueba PartirCola superada")
    }

    @Test
    fun probarEliminarElemento() {
        // Creamos una cola con letras, algunas repetidas
        val cola = Queue('m', 'g', '#', 'h', 'Q', 't', 'a', 'g', 's', '&', 'm', 'u', '9', '&', 'd')
        var res: IQueue<Char> = eliminarElementoCola(cola, 'm')
        var col: IQueue<Char> = Queue('g', '#', 'h', 'Q', 't', 'a', 'g', 's', '&', 'u', '9', '&', 'd')
        assertEquals(col, res, "La cola resultante de eliminar la m está incorrecta!")

        // Otra prueba
        res = eliminarElementoCola(res, 'g')
        col = Queue('#', 'h', 'Q', 't', 'a', 's', '&', 'u', '9', '&', 'd')
        assertEquals(col, res, "La cola resultante de eliminar la g está mal!")

        // Mensaje final
        println("Prueba de Eliminar elemento superad!")
    }

}


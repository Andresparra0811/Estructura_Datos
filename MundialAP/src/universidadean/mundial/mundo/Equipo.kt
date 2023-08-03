/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoCrearEquipo.java, v 1.5 $
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Basado en el proyecto Cupi2 de Uniandes
 * Ejercicio: Mundial
 * Fecha: 04-noviembre-2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package universidadean.mundial.mundo

import ean.collections.IDictionary
import ean.collections.IList
import ean.collections.TDictionaryTree
import ean.collections.TList

/**
 * Esta excepción se lanza cuando se intenta agregar al mundial un elemento repetido. <br>
 * El mensaje asociado con la excepción debe indicar el equipo o el jugador que causó el error.
 */
class ElementoExisteException(nomElem: String) : Exception(nomElem)

/**
 * Es la clase que representa un equipo del mundial
 */
class Equipo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el vector con los jugadores del equipo
     */
    internal val jugadores: IDictionary<String, Jugador> = TDictionaryTree()

    /**
     * Es el nombre del país que representa el equipo
     */
    var pais: String = ""

    /**
     * Es el nombre del director técnico del equipo
     */
    var director: String = ""

    /**
     * Es la ruta de la imagen con la bandera del equipo
     */
    var imagen: String = ""

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo Equipo con los datos suministrados y sin jugadores
     */
    constructor(pais: String, director: String, imagen: String) {
        this.pais = pais
        this.director = director
        this.imagen = imagen
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna un jugador del equipo dado su nombre.
     * Si no se encontró retorna null.
     */
    fun darJugador(nombreJugador: String): Jugador? {
        return jugadores[nombreJugador]
    }

    /**
     * Adiciona un jugador al equipo.
     * Genera la excepción ElementoExisteException Si ya existía un jugador con el
     * mismo nombre del jugador que se recibe como parámetro
     */
    fun agregarJugador(j: Jugador) {
        if (j.nombre in jugadores){
            throw ElementoExisteException("El jugador ya existe")
        }
        jugadores[j.nombre]= j
    }

    /**
     * Retorna una lista con los nombres de los jugadores del equipo
     */
    fun darNombresJugadores(): IList<String> {
        var lista:IList<String> = TList()
        for (nom in jugadores.keys){
            lista.add(nom)
        }
        return lista
    }

    /**
     * Calcula el valor de la nómina del equipo
     */
    fun calcularValorNomina(): Double {
        var nomina = 0.0

        for (jug in jugadores.values){
            nomina += jug.salario

        }
        return nomina
    }

    /**
     * Modificación la información del jugador con el nombre dado. <br>
     */
    fun modificarInformacionJugador(nombre: String, edad: Int, posicion: String,
                                    altura: Double, peso: Double, salario: Double,
                                    imagen: String) {
        val jugador= jugadores[nombre]

        if (jugador != null){
            jugador.edad = edad
            jugador.posicion= posicion
            jugador.altura = altura
            jugador.peso = peso
            jugador.salario= salario
            jugador.imagen= imagen
        }
    }

    fun hallarJugadorMasViejo():String{
        var edadJugadorMayor= 0
        var nombreJugadorMayor= ""
        for (jugador in jugadores.values){
            if (jugador.edad > edadJugadorMayor ){
                edadJugadorMayor= jugador.edad
                nombreJugadorMayor= jugador.nombre
            }
        }
        return nombreJugadorMayor
    }

    fun hallarPromedioEdad():Double{
        var tamañoEquipo= jugadores.size
        var sumaEdad= 0
        for (jugador in jugadores.values){
            sumaEdad += jugador.edad
        }
        return ((sumaEdad.toDouble()/tamañoEquipo.toDouble()))
    }
}
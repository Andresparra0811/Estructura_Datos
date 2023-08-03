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

import ean.collections.IDictionary;
import ean.collections.IList
import ean.collections.TDictionaryTree;
import ean.collections.TList

// -----------------------------------------------------------------
// Constantes
// -----------------------------------------------------------------
//const val

/**
 * Es la clase para representar el mundial de fútbol
 */
class Mundial {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Los equipos que participan en el mundial. La llaves son los paises de cada equipo.
     */
    private val equipos: IDictionary<String, Equipo> = TDictionaryTree()

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    constructor()

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna un equipo del mundial dado su país.
     * Retorna el equipo cuyo nombre es igual al nombre dado. Si no se
     * encuentra, deberá retornarse null
     */
    fun darEquipo(nombreEquipo: String): Equipo? {
        return equipos[nombreEquipo]
    }

    /**
     * Agrega un nuevo equipo al mundial. El método crea un objeto equipo
     * Y si el equipo con ese nombre no existe, lo agrega al diccionario.
     * Si el equipo con ese nombre ya existe en el diccionario, se debe
     * generar la excepcion ElementoExisteException.
     */
    @Throws(ElementoExisteException::class)
    fun agregarEquipo(pais: String, director: String, imagen: String) {
        if (pais in equipos){
            throw ElementoExisteException("El jugador ya existe")
        }
        val equipoNuevo= Equipo(pais,director,imagen)
        equipos.put (pais,equipoNuevo)

    }

    /**
     * Retorna una lista con los nombres de los equipos
     */
    fun darNombresEquipos(): IList<String> {
        var lista:IList<String> = TList()
        for (paises in equipos.keys){
            lista.add(paises)
        }
        return lista
    }


    /**
     * Agrega un nuevo jugador al equipo.
     * La excepciónElementoExisteException se lanza si ya existe otro jugador en el equipo con el mismo nombre
     */
    @Throws(ElementoExisteException::class)
    fun agregarJugadorAEquipo(nombreEquipo: String, nombreJ: String, edadJ: Int, posicionJ: String, alturaJ: Double, pesoJ: Double, salarioJ: Double, imagenJ: String) {
        val equipoJugador=  equipos[nombreEquipo]
        if (equipoJugador != null){
            val jugadorIngresar= Jugador(nombreJ, edadJ, posicionJ, alturaJ, pesoJ, salarioJ, imagenJ)
            equipoJugador.agregarJugador(jugadorIngresar)
        }

    }

    /**
     * Cambia la información del jugador que tiene el nombre dado.
     * El nombre no es necesario cambiarlo.
     */
    fun cambiarInformaciónJugador(nombreEquipo: String, nombreJ: String, edadJ: Int, posicionJ: String, alturaJ: Double, pesoJ: Double, salarioJ: Double, imagenJ: String) {
        val equipoJugador=  equipos[nombreEquipo]
        if (equipoJugador != null){
            equipoJugador.modificarInformacionJugador(nombreJ, edadJ, posicionJ, alturaJ, pesoJ, salarioJ, imagenJ)
        }
    }
    /**
     * Calcula el valor de la nómina de un equipo
     * Retorna 0.0 si el equipo con el nombre dado no existe
     */
    fun calcularValorNomina(nombreEquipo: String): Double {
        val equipoJugador=  equipos[nombreEquipo]
        if (equipoJugador != null){
            return equipoJugador.calcularValorNomina()
        }
        return 0.0
    }

    /**
     * Retorna el nombre del jugador más viejo del equipo dado
     */
    fun metodo1(nombreEquipo: String): String {
        val equipoJugador=  equipos[nombreEquipo]
        var respuesta:String= ""
        if (equipoJugador != null){
            respuesta= equipoJugador.hallarJugadorMasViejo()
        }
        return respuesta
    }

    /**
     * Retorna el promedio de edad de los jugadores del equipo dado
     */
    fun metodo2(nombreEquipo: String): Double {
        val equipoJugador=  equipos[nombreEquipo]
        var respuesta:Double= 0.0
        if (equipoJugador != null){
            respuesta= equipoJugador.hallarPromedioEdad()
        }
        return respuesta
    }

}
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

/**
 * Es la clase que representa un jugador que hace parte de un equipo
 */
data class Jugador(var nombre: String,    // Es el nombre del jugador
                   var edad: Int,         // Es la edad del jugador
                   var posicion: String,  // Es la posición en la que juega el jugador
                   var altura: Double,    // Es la altura del jugador en metros
                   var peso: Double,      // Es el peso en kilogramos del jugador
                   var salario: Double,   // Es el salario anual del jugador en millones de pesos
                   var imagen: String     // Es la ruta a la imagen con la foto del jugador
                   ) : Comparable<Jugador> {

    // El criterio de comparación será el nombre del jugador
    override fun compareTo(other: Jugador): Int {
        return compareValuesBy(this.nombre,other.nombre)
    }

}

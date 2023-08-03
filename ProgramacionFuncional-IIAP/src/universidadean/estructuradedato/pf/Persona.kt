/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Utils.kt,v 1.0 2021/11/16 $
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Personas
 * Fecha: Nov 17 de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.estructuradedato.pf

/**
 * Información acerca de una persona de los que tenemos datos
 */
data class Persona(val cedula: Int,
                   val edad: Int,
                   val genero: Char,
                   val hijos: Int,
                   val nivelEducativo: String,
                   val estrato: Int,
                   val ingresos: Int,
                   val peso: Int,
                   val altura: Int,
                   val fuma: Boolean,
                   val usaLentes: Boolean,
                   val tieneCasa: Boolean,
                   val tieneAutomovil: Boolean)

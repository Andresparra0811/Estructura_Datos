/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Departamento.java,v 1.0 2017/02/17 08:09 lacobo Exp $
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Pais
 * Autor: Luis Cobo - Nov 11, 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.programacionavanzada.tallerprogramacionfuncional

/**
 * Representa la información que se guarda de un Departamento de Colombia
 */
class Departamento : Comparable<Departamento> {

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    private var _nombre: String = ""

    val nombre: String
        get() = _nombre

    var población: Int = 0
    var superficie: Double = 0.0
    var IDH: Double = 0.0
    var añoCreación: Int = 0

    //-----------------------------------------------------------------
    // Constructores - Debe inicializar todos los atributos
    //-----------------------------------------------------------------

    constructor()
    constructor(nombre: String, población: Int, superficie: Double, IDH: Double, añoCreación: Int) {
        this._nombre = nombre
        this.población = población
        this.superficie = superficie
        this.IDH = IDH
        this.añoCreación = añoCreación
    }

    //-----------------------------------------------------------------
    // Otros métodos
    //-----------------------------------------------------------------

    /**
     * Compara el objeto this con el otroDepartarmento. Retorna -1 si this es inferior a otroDepto
     * 0 si ambos son iguales, y 1 si this es superior a otroDepto. El criterio de comparación que
     * se usará será el nombre del departamento
     */
    override fun compareTo(otroDepto: Departamento): Int =
            compareValues(this.nombre, otroDepto.nombre)
}
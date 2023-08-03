/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Municipio.java,v 1.0 2017/02/17 08:09 lacobo Exp $
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Pais
 * Autor: Universidad EAN - Octubre 19, 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.programacionavanzada.pais

/**
 * Representa la información que tenemos de un Municipio del país
 */
class Municipio: Comparable<Municipio> {

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
    var código: Int = 0
    var nombre: String = ""
    var departamento: String = ""
    var poblaciónUrbana: Int = 0
    var poblaciónRural: Int = 0
    var esCapital: Boolean = false

    //-----------------------------------------------------------------
    // Constructor - Debe inicializar todos los atributos
    //-----------------------------------------------------------------

    constructor()
    constructor(código: Int, nombre: String, departamento: String, poblaciónUrbana: Int, poblaciónRural: Int, esCapital: Boolean) {
        this.código = código
        this.nombre = nombre
        this.departamento = departamento
        this.poblaciónUrbana = poblaciónUrbana
        this.poblaciónRural = poblaciónRural
        this.esCapital = esCapital
    }

    //-----------------------------------------------------------------
    // Otros métodos
    //-----------------------------------------------------------------

    /**
     * Compara el objeto this con el otroMunicipio. Retorna -1 si this es inferior a otroMunicipio
     * 0 si ambos son iguales, y 1 si this es superior a otroMunicipio. El criterio de comparación que
     * se usará será el nombre del municipio y el segundo criterio será el departamento
     */
    override fun compareTo(otroMunicipio: Municipio): Int {
        return compareValuesBy (this, otroMunicipio, Municipio::nombre, Municipio::departamento)
    }
}
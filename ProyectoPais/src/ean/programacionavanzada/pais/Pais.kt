/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Pais.java,v 1.0 2017/02/17 08:09 lacobo Exp $
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Pais
 * Autor: Luis Cobo - 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.programacionavanzada.pais

import ean.collections.IList


class Pais {
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    // TODO: Completar, colocar aquí los atributos

    //-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------
    constructor()

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Crea un nuevo departamento a partir de los datos de entrada y lo agrega a la lista de departamentos del pais
     * @param nombre
     * @param superficie
     * @param IDH
     * @param añoCreación
     */
    fun agregarDepartamento(nombre: String, superficie: Double, IDH: Double, añoCreación: Int) {
        TODO("Escribir la operación para agregar un departamento a la lista")
    }

    /**
     * Permite saber el número de departamentos que posee el país.
     * @return el tamaño de la lista de departamentos
     */
    fun numDepartamentos(): Int {
        TODO("Completar")
        return 0
    }

    /**
     * Crea un objeto municipio con los datos de entrada especificados y lo agrega al final de la lista de departamentos
     * @param código
     * @param nombre
     * @param departamento
     * @param poblaciónUrbana
     * @param poblaciónRural
     * @param esCapital
     */
    fun agregarMunicipio(código: Int, nombre: String, departamento: String, poblaciónUrbana: Int, poblaciónRural: Int, esCapital: Boolean) {
        TODO("Completar!!")
    }

    /**
     * Obtiene el número de municipios que hay en la lista
     * @return el tamaño de la lista de municipios
     */
    fun numMunicipios(): Int {
        TODO("Completar!")
    }

    /** Peremite obtener el número de municipios que hacen parte del departamento que
     * tiene el nombre dado.
     * @param nomDepto el departamento a buscar
     * @return el número de municipios de ese departamento
     */
    fun municipioDepto(nomDepto: String): Int {
        TODO()
        return 0
    }

    /**
     * Dado un departamento, retorna el nombre del municipio de ese departamento que es la capital
     * @param nomDepto el departamento a buscar
     * @return el nombre del municipio, o la cadena vacía "" si no hay capital para ese departamento
     */
    fun obtenerCapitalDepartamento(nomDepto: String): String {
        TODO()
        return ""
    }

    /**
     * Obtener el municipio que tiene un nombre dado
     * @return el objeto departamento que tiene el  nombre dado, o null si no existe un depto
     */
    fun obtenerDepartamento(nombreDepto: String): Departamento? {
        TODO()
        return null
    }

    /**
     * Obtener el departamento más grande del país, el de mayor superficie. Debe obtener todo el
     * departamento.
     * @return un objeto de la clase departamento
     */

    // TODO

    /**
     * Obtener la población total de un departamento dado. Suma las poblaciones rurales y urbanas
     * de todos los municipios que tiene ese departamento
     * @return la suma de las poblaciones
     */

    // TODO

    /**
     * Obtener el número de departamentos creados en la decada de los 10 del siglo pasado
     * @return la cantidad de departamentos
     */

    // TODO

    /**
     * Obtiene la densidad poblacional de un departamento. La densidad es la división entre la
     * población total de ese departamento y la superficie de ese departamento.
     * @param nombreDepto el nombre del departamento
     * @return la densidad = total_pobl / superficie
     */

    // TODO

    /**
     * Cuántos municipios tienen no tienen población urbana
     */

    // TODO

    /**
     * Listado de todos los nombres de los municipios de un departamento cuya población no supere los diez mil habitantes
     */

    // TODO
}
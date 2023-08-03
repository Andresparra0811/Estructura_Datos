/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Pais.java,v 1.0 2017/02/17 08:09 lacobo Exp $
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Pais
 * Autor: Universidad EAN - Octubre 19, 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.programacionavanzada.pais

import ean.collections.IBinTree
import ean.collections.TAVL
import ean.collections.IBinarySearchTree

class Pais {
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    private val deptos: IBinarySearchTree<Departamento> = TAVL()
    private val municipios: IBinarySearchTree<Municipio> = TAVL()

    //-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------
    constructor()

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Crea un nuevo departamento a partir de los datos de entrada y lo agrega al árbol de departamentos del pais
     * @param nombre
     * @param pobl
     * @param superficie
     * @param IDH
     * @param añoCreación
     */
    fun agregarDepartamento(nombre: String, pobl: Int, superficie: Double, IDH: Double, añoCreación: Int) {
        val d = Departamento(nombre, pobl, superficie, IDH, añoCreación)
        deptos.add(d)
    }

    /**
     * Permite saber el número de departamentos que posee el país.
     * @return el tamaño de la lista de departamentos
     */
    fun numDepartamentos(): Int {
        fun numDeptos(arbol: IBinarySearchTree<Departamento>): Int {
            var contador:Int = 0
            if (arbol.isEmpty){
                return contador
            }
            else{
                contador= numDeptos(arbol.left) + numDeptos(arbol.right)
                if (arbol.root != null){
                    contador++
                }
                return contador
            }
        }


        // Usamos la función anterior
        return numDeptos(deptos)
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
        val m = Municipio(código, nombre, departamento, poblaciónUrbana, poblaciónRural, esCapital)
        municipios.add(m)
    }

    /**
     * Obtiene el número de municipios que hay en la lista
     * @return el tamaño de la lista de municipios
     */
    fun numMunicipios(): Int {
        fun numMunicipios(arbol: IBinarySearchTree<Municipio>): Int {
            var contador:Int = 0
            if (arbol.isEmpty){
                return contador
            }
            else{
                contador= numMunicipios(arbol.left) + numMunicipios(arbol.right)
                if (arbol.root != null){
                    contador++
                }
                return contador
            }
        }

        // Usamos la función anterior
        return numMunicipios(municipios)
    }

    /**
     * Permite obtener el número de municipios que hacen parte del departamento que
     * tiene el nombre dado. Realice una función recursiva, de manera obligatoria
     * @param nomDepto el departamento a buscar
     * @return el número de municipios de ese departamento
     */
    fun municipioDepto(nomDepto: String): Int {
        // Función interna recursiva
        fun contar(arbol: IBinarySearchTree<Municipio>, nomd: String): Int =

            if (arbol.isEmpty){
                0
            }
            else{
                var contador = contar(arbol.left,nomd) + contar(arbol.right,nomd)
                if (arbol.root.departamento == nomd){
                    contador++
                    contador
                }
                else{
                    contador
                }
            }

        // Función principal
        return contar(municipios, nomDepto)
    }

    /**
     * Dado un departamento, retorna el nombre del municipio de ese departamento que es la capital
     * Utilice una función recursiva para solucionar el problema.
     *  @param nomDepto el departamento a buscar
     * @return el nombre del municipio, o la cadena vacía "" si no hay capital para ese departamento
     */
    fun obtenerCapitalDepartamento(nomDepto: String): String {
        fun buscar(a: IBinarySearchTree<Municipio>, d: String): Municipio? {
            if (a.isEmpty){
                return null

            }
            else{
                if (a.root.departamento == d && a.root.esCapital){
                    return a.root
                }
                else if (buscar(a.left,d) != null ){
                    return buscar (a.left,d)
                }
                else{
                    return buscar (a.right,d)
                }
            }
        }
        return buscar(municipios,nomDepto)!!.nombre
     }

    /**
     * Obtener el departamento que tiene un nombre dado
     * @return el objeto departamento que tiene el  nombre dado, o null si no existe un depto
     */
    fun obtenerDepartamento(nombreDepto: String): Departamento? {
        fun buscar(a: IBinarySearchTree<Departamento>, d: String): Departamento? {

            if (a.isEmpty){
                return null
            }
            else{
                if (a.root.nombre == d ){
                    return a.root
                }
                else if (a.root.nombre > d){
                    return buscar(a.left, d)
                }
                else {
                    return buscar(a.right, d)
                    }
            }
        }
        return buscar(deptos, nombreDepto)
    }


    /**
     * Obtener el departamento más grande del país, el de mayor superficie. Debe obtener todo el
     * departamento.
     * @return un objeto de la clase departamento
     */

    fun retornarDptoMasGrande():Departamento?{
        fun compararDeptosSuperficie(dpto1:Departamento?,dpto2:Departamento?):Departamento?{
            val comparadorSuperficie: Comparator<Departamento> = compareBy(Departamento::superficie)

            if (dpto1==null && dpto2 == null ){
                return null
            }

            else if (dpto1==null && dpto2 != null ){
                return dpto2
            }
            else if (dpto1!=null && dpto2 == null ){
                return dpto1
            }
            else {
                if (comparadorSuperficie.compare(dpto1, dpto2) > 0) {
                    return dpto1
                }
                else if (comparadorSuperficie.compare(dpto1, dpto2) < 0) {
                    return dpto2
                }
                else{
                    return null
                }
            }
        }
        fun departamentoMasGrande(a: IBinarySearchTree<Departamento>):Departamento?{
            if (a.isEmpty){
                return null
            }
            else{
                var mayorIzquierdo = departamentoMasGrande(a.left)
                var mayorDerecho = departamentoMasGrande(a.right)
                var mayorIzDer = compararDeptosSuperficie(mayorIzquierdo,mayorDerecho)
                var mayorDepto:Departamento?

                if (mayorIzDer != null) {
                    mayorDepto = compararDeptosSuperficie(mayorIzDer, a.root)
                }
                else{
                    mayorDepto = a.root
                }

                return mayorDepto
            }
        }
        return departamentoMasGrande(deptos)



    }

    /**
     * Obtener la población total de un departamento dado. Suma las poblaciones rurales y urbanas
     * de todos los municipios que tiene ese departamento
     * @return la suma de las poblaciones
     */

    fun calcularPoblacionTotal(dpto:String):Int?{
        fun calcularPoblacionDpto(a: IBinarySearchTree<Municipio>, d: String):Int{
            if (a.isEmpty){
                return 0
            }
            else{
                var poblaciontTotal= (calcularPoblacionDpto(a.left,d) + calcularPoblacionDpto(a.right,d) )
                if (a.root.departamento == d ){
                    return (poblaciontTotal + a.root.poblaciónRural + a.root.poblaciónUrbana)
                }
                else{
                return poblaciontTotal
                }
             }
        }
        return calcularPoblacionDpto(municipios,dpto)
    }


    /**
     * Obtener el número de departamentos creados en la decada de los 10 del siglo pasado
     * @return la cantidad de departamentos
     */

    fun deptosDecadaDiez(): Int {
        fun contar(arbol: IBinarySearchTree<Departamento>): Int =

            if (arbol.isEmpty){
                0
            }
            else{
                var contador = contar(arbol.left) + contar(arbol.right)
                if (arbol.root.añoCreación in 1910..1919){
                    contador++
                    contador
                }
                else{
                    contador
                }
            }
        return contar(deptos)
    }

    /**
     * Obtiene la densidad poblacional de un departamento. La densidad es la división entre la
     * población total de ese departamento y la superficie de ese departamento.
     * @param nombreDepto el nombre del departamento
     * @return la densidad = total_pobl / superficie
     */

    fun densidadPoblacional(departamento:String):Double{
        fun buscar(a: IBinarySearchTree<Departamento>, d: String): Departamento? {

            if (a.isEmpty){
                return null
            }
            else{
                if (a.root.nombre == d ){
                    return a.root
                }
                else if (a.root.nombre > d){
                    return buscar(a.left, d)
                }
                else {
                    return buscar(a.right, d)
                }
            }
        }
        fun calcularPoblacionDpto(a: IBinarySearchTree<Municipio>, d: String?):Int{
            if (a.isEmpty){
                return 0
            }
            else{
                var poblaciontTotal= (calcularPoblacionDpto(a.left,d) + calcularPoblacionDpto(a.right,d) )
                if (a.root.departamento == d ){
                    return (poblaciontTotal + a.root.poblaciónRural + a.root.poblaciónUrbana)
                }
                else{
                    return poblaciontTotal
                }
            }
        }

        return (calcularPoblacionDpto(municipios,buscar(deptos,departamento)!!.nombre).toDouble() / buscar(deptos,departamento)!!.superficie)
    }

    /**
     * Cuántos municipios tienen no tienen población urbana
     */

    fun noPoblacionUrbana ():Int{
        fun contar(arbol: IBinarySearchTree<Municipio>): Int =

            if (arbol.isEmpty){
                0
            }
            else{
                var contador = contar(arbol.left) + contar(arbol.right)
                if (arbol.root.poblaciónUrbana == 0){
                    contador++
                    contador
                }
                else{
                    contador
                }
            }
        return contar(municipios)
    }

}
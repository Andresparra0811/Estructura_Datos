/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller de Programacion Funcional
 * @author (@universidadean.edu.co)
 * Fecha: 10 de noviembre de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.programacionavanzada.tallerprogramacionfuncional

import ean.collections.IList

// Determinar el número de ciudades capitales de la lista
fun contarCapitales(mun: IList<Municipio>): Int {
     var contador= 0
     val esCapital = {m:Municipio -> m.esCapital }

     contador = mun.count(esCapital)
     return contador
}
/**
 * Retorna el numero de municipios sin poblacion urbana
 */
fun sinPoblacionUrbana(mun: IList<Municipio>): Int {
    var contador= 0
    val noPoblacionU = {m:Municipio -> m.poblaciónUrbana==0}

    contador = mun.count(noPoblacionU)
    return contador
}
//----------------------------------------------------

/**
 * Retorne el nombre del primer municipio que inicia con J
 */
fun munConJota(mun: IList<Municipio>): String? {
    val municipioJ= mun.find {  m -> m.nombre.startsWith("J") }
    return municipioJ!!.nombre
}
/**
 * Nombres de los deptos creados en el siglo XIX
 */
fun depSXIX(dptos: IList<Departamento>): IList<String> {
    val listaDptos = dptos.filter { m -> m.añoCreación in 1801..1900 }
    return listaDptos.map { it.nombre }
}


/**
 * Encontrar el número que tiene más digitos en una lista
 */
fun numMasDigitos(lst: IList<Int>): Int? {
    val mayor = {a:Int,b:Int -> if (a>b) 1 else if (a<b) -1 else 0}
    return lst.maxWith(mayor)
}

data class Nota(val definitiva: Double, val créditos: Int)








